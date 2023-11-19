package invictus.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import invictus.app.entity.Produto;

import java.util.List;

@Dao
public interface ProdutoDao {
    @Insert
    long insert(Produto produto);

    @Update
    int update(Produto produto);

    @Delete
    int delete(Produto produto);

    @Query("SELECT * FROM produtos")
    List<Produto> getAll();

    @Query("SELECT * FROM produtos WHERE id = :id")
    Produto getById(int id);
}
