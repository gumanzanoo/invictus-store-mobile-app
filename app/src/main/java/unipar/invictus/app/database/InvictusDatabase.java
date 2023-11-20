package unipar.invictus.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import unipar.invictus.app.dao.ClienteDao;
import unipar.invictus.app.dao.ItemsVendaDao;
import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.dao.UsuarioDao;
import unipar.invictus.app.dao.VendaDao;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.entity.ItemsVenda;
import unipar.invictus.app.entity.Produto;
import unipar.invictus.app.entity.Usuario;
import unipar.invictus.app.entity.Venda;

@Database(entities = {
        Cliente.class,
        Produto.class,
        Usuario.class,
        Venda.class,
        ItemsVenda.class
}, version = 1, exportSchema = false)

public abstract class InvictusDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();

    public abstract ProdutoDao produtoDao();

    public abstract UsuarioDao usuarioDao();

    public abstract VendaDao vendaDao();

    public abstract ItemsVendaDao itemsVendaDao();
}
