package br.com.faculdade.almoxarifado.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdade.almoxarifado.model.Item;

public interface ItemRepositoy extends JpaRepository<Item, Long> {
    
    Page<Item> findByNomeItem(String nomeItem, Pageable pageable);
}
