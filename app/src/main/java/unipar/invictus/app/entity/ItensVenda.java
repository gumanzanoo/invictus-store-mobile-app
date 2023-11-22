package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

public class ItensVenda {
    private int id;

    private int idVenda;

    private int idProduto;

    private int quantidade;

    private Produto produto;

    public ItensVenda() {
    }

    public ItensVenda(int id, int idVenda, int idProduto, int quantidade, Produto produto) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.produto = produto;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @NonNull
    @Override
    public String toString() {
        return "ItensVenda{" +
                "id=" + id +
                ", idVenda=" + idVenda +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
