package br.com.faculdade.almoxarifado.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long idItem;

    private String nomeItem;
    private String codigo;

    public Item() { }

    public Item(Long idItem) {
        this.idItem = idItem;
    }

    public Item(String nomeItem, String codigo) {
        this.nomeItem = nomeItem;
        this.codigo = codigo;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
