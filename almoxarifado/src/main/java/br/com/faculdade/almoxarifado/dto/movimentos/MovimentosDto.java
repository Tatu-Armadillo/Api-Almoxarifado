package br.com.faculdade.almoxarifado.dto.movimentos;

import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.faculdade.almoxarifado.model.Movimentos;

public class MovimentosDto {

    private Date data;
    private boolean entradaSaida;
    private String item;
    private String responsavel;

    public MovimentosDto(Movimentos movimento) {
        this.data = movimento.getData();
        this.entradaSaida = movimento.isEntradaSaida();
        this.item = movimento.getItem();
        this.responsavel = movimento.getResponsavel();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getNomeItem() {
        return item;
    }

    public void setNomeItem(String nomeItem) {
        this.item = nomeItem;
    }

    public boolean isEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(boolean entradaSaida) {
        this.entradaSaida = entradaSaida;
    }


    public static Page<MovimentosDto> converter(Page<Movimentos> movimento) {
        return movimento.map(MovimentosDto::new);
    }

}
