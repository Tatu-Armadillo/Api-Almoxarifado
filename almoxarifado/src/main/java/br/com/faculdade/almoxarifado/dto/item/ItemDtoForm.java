package br.com.faculdade.almoxarifado.dto.item;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.faculdade.almoxarifado.model.Item;
import br.com.faculdade.almoxarifado.repository.ItemRepositoy;

public class ItemDtoForm {

    @NotNull
    @NotEmpty
    @Length(max = 4, min = 4)
    private String codigo;
    @NotNull
    @NotEmpty
    @Length(min = 4)
    private String nomeItem;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Item converter(ItemRepositoy itemRespositoy) {
        return new Item(nomeItem, codigo);
    }

    public Item atualizar(Long id, ItemRepositoy itemRespositoy) {
        Item item = itemRespositoy.getById(id);
        item.setCodigo(this.codigo);
        item.setNomeItem(this.nomeItem);
        return item;
    }

}
