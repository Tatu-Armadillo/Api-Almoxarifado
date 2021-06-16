package br.com.faculdade.almoxarifado.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Sort.Direction;

import br.com.faculdade.almoxarifado.dto.movimentos.MovimentosDto;
import br.com.faculdade.almoxarifado.dto.movimentos.MovimentosFormDto;
import br.com.faculdade.almoxarifado.model.Movimentos;
import br.com.faculdade.almoxarifado.repository.MovimentosRepository;


@RestController
@RequestMapping("/movimentos")
public class MovimentosController {
    
    @Autowired
    private MovimentosRepository movimentosRepository;

    @GetMapping
    public Page<MovimentosDto> visualizarMovimentos(@PageableDefault(sort = "idMovimentos", direction = Direction.ASC) Pageable pagina) {

        Page<Movimentos> movimento = movimentosRepository.findAll(pagina);
        return MovimentosDto.converter(movimento);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MovimentosDto> realizarMovimento(@RequestBody @Valid MovimentosFormDto movimentoDtoForm,
            UriComponentsBuilder uriComponentsBuilder) {

        Movimentos movimento = movimentoDtoForm.converter(movimentosRepository);
        movimentosRepository.save(movimento);

        URI uri = uriComponentsBuilder.path("/movimentos{id}").buildAndExpand(movimento.getIdMovimentos()).toUri();
        return ResponseEntity.created(uri).body(new MovimentosDto(movimento));
    }
}
