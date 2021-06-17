package br.com.faculdade.almoxarifado.dto.item;

import org.springframework.data.domain.Page;

import br.com.faculdade.almoxarifado.model.Item;

public class ItemDto {

    private int idItem;
    private String codigo;
    private String nomeItem;

    public ItemDto(Item item) {
        this.idItem = item.getIdItem();
        this.codigo = item.getCodigo();
        this.nomeItem = item.getNomeItem();
    }

    public int getIdItem() {
        return idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Page<ItemDto> converter(Page<Item> itens) {
        return itens.map(ItemDto::new);
    }

}
