package unipar.invictus.app.entity;

import androidx.annotation.NonNull;

public class Venda {
    private int id;

    private int clienteId;

    private double valorTotal;

    public Venda() {
    }

    public Venda(int id, int clienteId, double valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
