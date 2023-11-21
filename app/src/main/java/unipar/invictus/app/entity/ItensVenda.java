package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

public class ItensVenda {
    private int id;

    private int idVenda;

    private int idProduto;

    private int quantidade;

    public ItensVenda() {
    }

    public ItensVenda(int id, int idVenda, int idProduto, int quantidade) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
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
