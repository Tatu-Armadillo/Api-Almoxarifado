package br.com.faculdade.almoxarifado.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_movimentos")
public class Movimentos {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentos")
    private Long idMovimentos;

    private Date data;

    @Column(name = "Entrada_Saida")
    private boolean entradaSaida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_Itens_id_item", referencedColumnName = "id_item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "fk_Responsaveis_id_responsavel", referencedColumnName = "id_responsavel")
    private Responsavel responsavel;

    public Movimentos() {
    }

    public Movimentos(Date data, boolean entradaSaida, Item item, Responsavel responsavel) {
        this.data = data;
        this.entradaSaida = entradaSaida;
        this.item = item;
        this.responsavel = responsavel;
    }

    public Long getIdMovimentos() {
        return idMovimentos;
    }

    public void setIdMovimentos(Long idMovimentos) {
        this.idMovimentos = idMovimentos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(boolean entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }
}
