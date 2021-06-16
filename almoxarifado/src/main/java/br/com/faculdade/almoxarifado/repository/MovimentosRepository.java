package br.com.faculdade.almoxarifado.repository;

// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdade.almoxarifado.model.Movimentos;

public interface MovimentosRepository extends JpaRepository<Movimentos, Long> {

    
}
