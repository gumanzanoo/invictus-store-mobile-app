package com.example.invictus.app.entity;

public class ItemsVenda {
    private int id;
    private int idVenda;
    private int idProduto;

    public ItemsVenda() {
    }

    public ItemsVenda(int id, int idVenda, int idProduto) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
