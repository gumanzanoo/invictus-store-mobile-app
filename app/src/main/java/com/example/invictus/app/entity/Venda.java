package com.example.invictus.app.entity;

public class Venda {
    private int id;
    private int clienteId;
    private int produtoId;
    private double valorTotal;

    public Venda() {
    }

    public Venda(int id, int clienteId, int produtoId, double valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
