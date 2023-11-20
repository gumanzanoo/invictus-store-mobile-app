package unipar.invictus.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "produtos")
public class Produto {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "cod")
    private String cod;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "valorUnitario")
    private double valorUnitario;

    @ColumnInfo(name = "qtdEstoque")
    private int qtdEstoque;

    public Produto() {
    }

    @Ignore
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


