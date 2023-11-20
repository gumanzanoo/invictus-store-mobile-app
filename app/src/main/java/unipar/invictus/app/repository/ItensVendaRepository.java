package unipar.invictus.app.repository;

import android.content.Context;

import androidx.room.Room;

import unipar.invictus.app.dao.ItensVendaDao;
import unipar.invictus.app.database.InvictusDatabase;

public class ItensVendaRepository {
    private final ItensVendaDao itensVendaDao;

    public ItensVendaRepository(Context context) {
        InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "InvictusDatabase").build();
        itensVendaDao = database.itensVendaDao();
    }

    public long insert(unipar.invictus.app.entity.ItensVenda itensVenda) {
        return itensVendaDao.insert(itensVenda);
    }

    public int update(unipar.invictus.app.entity.ItensVenda itensVenda) {
        return itensVendaDao.update(itensVenda);
    }

    public int delete(unipar.invictus.app.entity.ItensVenda itensVenda) {
        return itensVendaDao.delete(itensVenda);
    }

    public java.util.List<unipar.invictus.app.entity.ItensVenda> getAll() {
        return itensVendaDao.getAll();
    }

    public unipar.invictus.app.entity.ItensVenda getById(int id) {
        return itensVendaDao.getById(id);
    }
}
