package invictus.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "items_venda",
        foreignKeys = {
                @ForeignKey(entity = Produto.class, parentColumns = "id", childColumns = "id_produto", onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Venda.class, parentColumns = "id", childColumns = "id_venda", onDelete = ForeignKey.CASCADE)
        },
        indices = {
                @Index("id_produto"),
                @Index("id_venda")
        })

public class ItemsVenda {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "id_venda")
    private int idVenda;

    @ColumnInfo(name = "id_produto")
    private int idProduto;

    @ColumnInfo(name = "quantidade")
    private int quantidade;

    public ItemsVenda() {
    }

    @Ignore
    public ItemsVenda(int id, int idVenda, int idProduto, int quantidade) {
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
}
