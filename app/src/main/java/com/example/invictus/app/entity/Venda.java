package com.example.invictus.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "vendas",
        foreignKeys = {
                @ForeignKey(entity = Cliente.class, parentColumns = "id", childColumns = "cliente_id", onDelete = ForeignKey.CASCADE)
        })

public class Venda {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "cliente_id")
    private int clienteId;

    @ColumnInfo(name = "valor_total")
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
}
