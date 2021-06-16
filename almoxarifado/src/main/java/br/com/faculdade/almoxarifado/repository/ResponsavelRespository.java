package br.com.faculdade.almoxarifado.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdade.almoxarifado.model.Responsavel;

public interface ResponsavelRespository extends JpaRepository<Responsavel, Long> {

    Page<Responsavel> findByNomeResponsavel(String nomeResponsavel, Pageable pagina);

}
