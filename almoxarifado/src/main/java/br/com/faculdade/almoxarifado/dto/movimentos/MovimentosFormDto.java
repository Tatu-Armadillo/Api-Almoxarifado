package br.com.faculdade.almoxarifado.dto.movimentos;

import java.util.Date;

import br.com.faculdade.almoxarifado.model.*;
import br.com.faculdade.almoxarifado.model.Movimentos;
import br.com.faculdade.almoxarifado.repository.MovimentosRepository;

public class MovimentosFormDto {

    private Date data;
    private boolean entradaSaida;
    private Item item;
    private Responsavel responsavel;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item nomeItem) {
        this.item = nomeItem;
    }

    public boolean isEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(boolean entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public Movimentos converter(MovimentosRepository movimentosRepository) {
        return new Movimentos(data, entradaSaida, item, responsavel);
    }

    public Movimentos atualizarResponsavel(Long id, MovimentosRepository responsavelRespository) {{
        Movimentos movimento = responsavelRespository.getById(id);
        movimento.setData(this.data);
        movimento.setEntradaSaida(this.entradaSaida);
        movimento.setItem(this.item);
        movimento.setResponsavel(this.responsavel);
        return movimento;
    }}
}
