package br.com.faculdade.almoxarifado.dto.movimentos;

import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.faculdade.almoxarifado.model.Item;
import br.com.faculdade.almoxarifado.model.Movimentos;
import br.com.faculdade.almoxarifado.model.Responsavel;

public class MovimentosDto {

    private Date data;
    private boolean entradaSaida;
    private Item item;
    private Responsavel responsavel;

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

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Item getNomeItem() {
        return item;
    }

    public void setNomeItem(Item nomeItem) {
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
