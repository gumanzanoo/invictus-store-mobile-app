package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Venda {
    private int id;

    private int clienteId;

    private double valorTotal;

    private ArrayList<ItensVenda> itensVenda;

    public Venda() {
    }

    public Venda(int id, int clienteId, double valorTotal, ArrayList<ItensVenda> itensVenda) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.itensVenda = itensVenda;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<ItensVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItensVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    @NonNull
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
