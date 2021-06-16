package br.com.faculdade.almoxarifado.dto.responsavel;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import br.com.faculdade.almoxarifado.model.Responsavel;
import br.com.faculdade.almoxarifado.repository.ResponsavelRespository;

public class ResponsavelDtoForm {

    @NotNull
    @NotEmpty
    @Length(min = 4)
    private String nomeResponsavel;

    @NotNull
    @NotEmpty
    @Length(min = 8, max = 9)
    private String numeroContato;

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public Responsavel converter(ResponsavelRespository responsavelRespository) {
        return new Responsavel(nomeResponsavel, numeroContato);
    }

    public Responsavel atualizarResponsavel(Long id, ResponsavelRespository responsavelRespository) {{
        Responsavel responsavel = responsavelRespository.getById(id);
        responsavel.setNomeResponsavel(this.nomeResponsavel);
        responsavel.setNumeroContato(this.numeroContato);
        return responsavel;
    }}
}
