package invictus.app.repository;

import android.content.Context;

import androidx.room.Room;

import invictus.app.dao.ClienteDao;
import invictus.app.database.InvictusDatabase;
import invictus.app.entity.Cliente;

import java.util.List;

public class ClienteRepository {
        private ClienteDao clienteDao;

        public ClienteRepository(Context context) {
            InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "app-database").build();
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
