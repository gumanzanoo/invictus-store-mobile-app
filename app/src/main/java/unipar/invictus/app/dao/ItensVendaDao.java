package unipar.invictus.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import unipar.invictus.app.entity.ItensVenda;

@Dao
public interface ItensVendaDao {
    @Insert
    long insert(ItensVenda itensVenda);

    @Update
    int update(ItensVenda itensVenda);

    @Delete
    int delete(ItensVenda itensVenda);

    @Query("SELECT * FROM itens_venda")
    List<ItensVenda> getAll();

    @Query("SELECT * FROM itens_venda WHERE id = :id")
    ItensVenda getById(int id);
}
