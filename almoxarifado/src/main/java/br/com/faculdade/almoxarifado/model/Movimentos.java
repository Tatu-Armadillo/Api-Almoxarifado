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

    @ManyToOne
    @JoinColumn(name = "tb_itens", referencedColumnName = "id_item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_adm", foreignKey = @ForeignKey(name = "fk_Usuarios_id_adm"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", foreignKey = @ForeignKey(name = "fk_Responsaveis_id_responsavel"))
    private Responsavel responsavel;

    public Movimentos() {
    }

    public Movimentos(Long idMovimentos, Date data, boolean entradaSaida, Item item, Usuario usuario,
            Responsavel responsavel) {
        this.idMovimentos = idMovimentos;
        this.data = data;
        this.entradaSaida = entradaSaida;
        this.item = item;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }
}
