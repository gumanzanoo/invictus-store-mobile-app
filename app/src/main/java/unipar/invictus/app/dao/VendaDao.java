package unipar.invictus.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import unipar.invictus.app.entity.Venda;

@Dao
public interface VendaDao {
    @Insert
    long insert(Venda vendas);

    @Update
    int update(Venda vendas);

    @Delete
    int delete(Venda vendas);

    @Query("SELECT * FROM vendas")
    List<Venda> getAll();

    @Query("SELECT * FROM vendas WHERE id = :id")
    Venda getById(int id);
}
