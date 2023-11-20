package unipar.invictus.app.repository;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

import unipar.invictus.app.dao.UsuarioDao;
import unipar.invictus.app.database.InvictusDatabase;
import unipar.invictus.app.entity.Usuario;

public class UsuarioRepository {
    private final UsuarioDao usuarioDao;

    public UsuarioRepository(Context context) {
        InvictusDatabase database = Room.databaseBuilder(context, InvictusDatabase.class, "InvictusDatabase").build();
        usuarioDao = database.usuarioDao();
    }

    public long insert(Usuario usuario) {
        return usuarioDao.insert(usuario);
    }

    public int update(Usuario usuario) {
        return usuarioDao.update(usuario);
    }

    public int delete(Usuario usuario) {
        return usuarioDao.delete(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioDao.getAll();
    }

    public Usuario getById(int id) {
        return usuarioDao.getById(id);
    }

    public Usuario getByEmail(String email) {
        return usuarioDao.getByEmail(email);
    }
}
