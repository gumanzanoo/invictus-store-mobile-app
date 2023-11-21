package unipar.invictus.app.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import unipar.invictus.app.dao.ProdutoDao;
import unipar.invictus.app.database.InvictusDatabase;
import unipar.invictus.app.entity.Produto;

public class ProdutoRepository {
    private final ProdutoDao produtoDao;

    public ProdutoRepository(Context context) {
        InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "InvictusDatabase").build();
        produtoDao = database.produtoDao();
    }

    public long insert(Produto produto) {
        return produtoDao.insert(produto);
    }

    public int update(Produto produto) {
        return produtoDao.update(produto);
    }

    public int delete(Produto produto) {
        return produtoDao.delete(produto);
    }

    public List<Produto> getAll() {
        return produtoDao.getAll();
    }

    public Produto getById(int id) {
        return produtoDao.getById(id);
    }
}
