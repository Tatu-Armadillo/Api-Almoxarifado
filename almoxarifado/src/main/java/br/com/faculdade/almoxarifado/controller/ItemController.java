package br.com.faculdade.almoxarifado.controller;

import java.net.URI;
import java.util.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Sort.Direction;

import br.com.faculdade.almoxarifado.dto.item.*;
import br.com.faculdade.almoxarifado.model.Item;
import br.com.faculdade.almoxarifado.repository.ItemRepositoy;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepositoy itemRespositoy;

    @GetMapping
    public Page<ItemDto> visualizarItens(@RequestParam(required = false) String nomeItem,
            @PageableDefault(sort = "idItem", direction = Direction.ASC) Pageable pagina) {
        if (nomeItem == null) {
            Page<Item> itens = itemRespositoy.findAll(pagina);
            return ItemDto.converter(itens);
        } else {
            Page<Item> itens = itemRespositoy.findByNomeItem(nomeItem, pagina);
            return ItemDto.converter(itens);
        }
    }

    @GetMapping("/{idItem}")
    public ResponseEntity<ItemDto> detalharItem(@PathVariable Long idItem) {
        Optional<Item> item = itemRespositoy.findById(idItem);
        if (item.isPresent()) {
            return ResponseEntity.ok(new ItemDto(item.get()));
        } else {
            return ResponseEntity.notFound().build();   
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ItemDto> cadastrarItens(@RequestBody @Valid ItemDtoForm itemDtoForm,
            UriComponentsBuilder uriComponentsBuilder) {

        Item item = itemDtoForm.converter(itemRespositoy);
        itemRespositoy.save(item);

        URI uri = uriComponentsBuilder.path("/itens{id}").buildAndExpand(item.getIdItem()).toUri();
        return ResponseEntity.created(uri).body(new ItemDto(item));
    }

    @PutMapping("/{idItem}")
    @Transactional
    public ResponseEntity<ItemDto> atualizarItem(@PathVariable Long idItem, @RequestBody ItemDtoForm itemDtoForm) {
        Item item = itemDtoForm.atualizar(idItem, itemRespositoy);
        return ResponseEntity.ok(new ItemDto(item));
    }

    @DeleteMapping("/{idItem}")
    @Transactional
    public ResponseEntity<?> removerItem(@PathVariable Long idItem) {
        itemRespositoy.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
