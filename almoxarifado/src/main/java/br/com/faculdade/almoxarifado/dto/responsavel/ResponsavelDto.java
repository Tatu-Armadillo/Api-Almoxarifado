package br.com.faculdade.almoxarifado.dto.responsavel;

import org.springframework.data.domain.Page;

import br.com.faculdade.almoxarifado.model.Responsavel;

public class ResponsavelDto {

    private int idResponsavel;
    private String nomeResponsavel;
    private String numeroContato;

    public ResponsavelDto(Responsavel responsavel) {
        this.idResponsavel = responsavel.getIdResponsavel();
        this.nomeResponsavel = responsavel.getNomeResponsavel();
        this.numeroContato = responsavel.getNumeroContato();
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public static Page<ResponsavelDto> converter(Page<Responsavel> responsaveis) {
        return responsaveis.map(ResponsavelDto::new);
    }

}
