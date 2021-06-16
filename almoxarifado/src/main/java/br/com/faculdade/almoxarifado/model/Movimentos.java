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

    // @ManyToOne
    // @JoinColumn(name = "tb_itens", foreignKey = @ForeignKey(name = "fk_Itens_id_item"))
    private String item;

    // @ManyToOne
    // @JoinColumn(name = "id_adm", foreignKey = @ForeignKey(name =
    // "fk_Usuarios_id_adm"))
    private String usuario;

    // @ManyToOne
    // @JoinColumn(name = "id_responsavel", foreignKey = @ForeignKey(name = "fk_Responsaveis_id_responsavel"))
    private String responsavel;

    public Movimentos() {
    }

    public Movimentos(Date data, boolean entradaSaida, String item, String responsavel, String usuario) {
        this.data = data;
        this.entradaSaida = entradaSaida;
        this.item = item;
        this.responsavel = responsavel;
        this.usuario = usuario;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUsuario() {
    return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }
}
