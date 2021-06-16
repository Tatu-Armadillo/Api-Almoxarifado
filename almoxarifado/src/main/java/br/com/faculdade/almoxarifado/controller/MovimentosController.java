package br.com.faculdade.almoxarifado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort.Direction;

import br.com.faculdade.almoxarifado.dto.movimentos.MovimentosDto;
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
}
