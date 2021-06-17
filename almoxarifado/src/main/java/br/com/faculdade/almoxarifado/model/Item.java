package br.com.faculdade.almoxarifado.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int idItem;

    private String nomeItem;
    private String codigo;

    public Item() {
    }

    public Item(String nomeItem, String codigo) {
        this.nomeItem = nomeItem;
        this.codigo = codigo;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
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
