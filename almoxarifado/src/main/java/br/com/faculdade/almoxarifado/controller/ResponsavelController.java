package br.com.faculdade.almoxarifado.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.faculdade.almoxarifado.dto.responsavel.ResponsavelDto;
import br.com.faculdade.almoxarifado.dto.responsavel.ResponsavelDtoForm;
import br.com.faculdade.almoxarifado.model.Responsavel;
import br.com.faculdade.almoxarifado.repository.ResponsavelRespository;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelRespository responsavelRespository;

    @GetMapping
    public Page<ResponsavelDto> visualizarResponsaveis(@RequestParam(required = false) String nomeResponsavel,
            @PageableDefault(sort = "idResponsavel", direction = Direction.ASC) Pageable pagina) {
        if (nomeResponsavel == null) {
            Page<Responsavel> responsaveis = responsavelRespository.findAll(pagina);
            return ResponsavelDto.converter(responsaveis);
        } else {
            Page<Responsavel> responsaveis = responsavelRespository.findByNomeResponsavel(nomeResponsavel, pagina);
            return ResponsavelDto.converter(responsaveis);
        }
    }

    @GetMapping("/{idResponsavel}")
    public ResponseEntity<ResponsavelDto> detalharResponsavel(@PathVariable Long idResponsavel) {
        Optional<Responsavel> responsavel = responsavelRespository.findById(idResponsavel);
        if (responsavel.isPresent()) {
            return ResponseEntity.ok(new ResponsavelDto(responsavel.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @Transactional
    ResponseEntity<ResponsavelDto> cadastrarResponsaveis(@RequestBody @Valid ResponsavelDtoForm responsavelDtoForm,
            UriComponentsBuilder uriComponentsBuilder) {
        Responsavel responsavel = responsavelDtoForm.converter(responsavelRespository);
        responsavelRespository.save(responsavel);

        URI uri = uriComponentsBuilder.path("/responsaveis{idResponsavel}")
                .buildAndExpand(responsavel.getIdResponsavel()).toUri();
        return ResponseEntity.created(uri).body(new ResponsavelDto(responsavel));
    }

    @PutMapping("/{idResponsavel}")
    @Transactional
    public ResponseEntity<ResponsavelDto> atulizarResposavel(@PathVariable Long idResponsavel,
            @RequestBody ResponsavelDtoForm responsavelDto) {
        Responsavel responsavel = responsavelDto.atualizarResponsavel(idResponsavel, responsavelRespository);
        return ResponseEntity.ok(new ResponsavelDto(responsavel));
    }

    @DeleteMapping("/{idResponsavel}")
    @Transactional
    public ResponseEntity<?> removerResonsavel(@PathVariable Long idResponsavel) {
        responsavelRespository.deleteById(idResponsavel);
        return ResponseEntity.ok().build();
    }
}
