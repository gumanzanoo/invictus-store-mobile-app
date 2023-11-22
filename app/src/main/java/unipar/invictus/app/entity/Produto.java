package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

public class Produto {
    private int id;

    private int cod;

    private String descricao;

    private double valorUnitario;

    private int qtdEstoque;

    private int quantidadeVendida;

    public Produto() {
    }

    public Produto(int id, int cod, String descricao, double valorUnitario, int qtdEstoque, int quantidadeVendida) {
        this.id = id;
        this.cod = cod;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
        this.quantidadeVendida = quantidadeVendida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
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

    public int getQuantidadeVenda() {
        return quantidadeVendida;
    }

    public void setQuantidadeVenda(int quantidadeComprada) {
        this.quantidadeVendida = quantidadeComprada;
    }

    @NonNull
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", cod=" + cod +
                ", descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }
}


