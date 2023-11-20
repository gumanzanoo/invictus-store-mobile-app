package unipar.invictus.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import unipar.invictus.app.entity.Usuario;

@Dao
public interface UsuarioDao {

    @Insert
    long insert(Usuario usuario);

    @Update
    int update(Usuario usuario);

    @Delete
    int delete(Usuario usuario);

    @Query("SELECT * FROM usuarios")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuarios WHERE id = :id")
    Usuario getById(int id);

    @Query("SELECT * FROM usuarios WHERE email = :email")
    Usuario getByEmail(String email);
}
