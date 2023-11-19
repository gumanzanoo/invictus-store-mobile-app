package com.example.invictus.app.entity;

public class Produto {
    private int id;
    private String cod;
    private String descricao;
    private double valorUnitario;
    private int qtdEstoque;

    public Produto() {
    }

    public Produto(int id, String cod, String descricao, double valorUnitario, int qtdEstoque) {
        this.id = id;
        this.cod = cod;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}


