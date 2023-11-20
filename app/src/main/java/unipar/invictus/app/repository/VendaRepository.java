package unipar.invictus.app.repository;

import android.content.Context;

import androidx.room.Room;

import unipar.invictus.app.dao.VendaDao;
import unipar.invictus.app.database.InvictusDatabase;

public class VendaRepository {
    private final VendaDao vendaDao;

    public VendaRepository(Context context) {
        InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "InvictusDatabase").build();
        vendaDao = database.vendaDao();
    }

    public long insert(unipar.invictus.app.entity.Venda venda) {
        return vendaDao.insert(venda);
    }

    public int update(unipar.invictus.app.entity.Venda venda) {
        return vendaDao.update(venda);
    }

    public int delete(unipar.invictus.app.entity.Venda venda) {
        return vendaDao.delete(venda);
    }

    public java.util.List<unipar.invictus.app.entity.Venda> getAll() {
        return vendaDao.getAll();
    }
}
