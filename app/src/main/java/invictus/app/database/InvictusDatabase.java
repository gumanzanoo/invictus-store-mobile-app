package invictus.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import invictus.app.dao.ClienteDao;
import invictus.app.dao.ItemsVendaDao;
import invictus.app.dao.ProdutoDao;
import invictus.app.dao.VendaDao;
import invictus.app.entity.Cliente;
import invictus.app.entity.ItemsVenda;
import invictus.app.entity.Produto;
import invictus.app.entity.Venda;

@Database(entities = {
        Cliente.class,
        Produto.class,
        Venda.class,
        ItemsVenda.class
}, version = 1, exportSchema = false)

public abstract class InvictusDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();

    public abstract ProdutoDao produtoDao();

    public abstract VendaDao vendaDao();

    public abstract ItemsVendaDao itemsVendaDao();
}
