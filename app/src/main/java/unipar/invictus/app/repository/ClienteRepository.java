package unipar.invictus.app.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import unipar.invictus.app.dao.ClienteDao;
import unipar.invictus.app.database.InvictusDatabase;
import unipar.invictus.app.entity.Cliente;

public class ClienteRepository {
    private ClienteDao clienteDao;

    public ClienteRepository(Context context) {
        InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "InvictusDatabase").build();
        clienteDao = database.clienteDao();
    }

    public long insert(Cliente cliente) {
        return clienteDao.insert(cliente);
    }

    public int update(Cliente cliente) {
        return clienteDao.update(cliente);
    }

    public int delete(Cliente cliente) {
        return clienteDao.delete(cliente);
    }

    public List<Cliente> getAll() {
        return clienteDao.getAll();
    }

    public Cliente getById(int id) {
        return clienteDao.getById(id);
    }
}
