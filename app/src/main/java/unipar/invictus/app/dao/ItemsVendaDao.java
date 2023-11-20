package unipar.invictus.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import unipar.invictus.app.entity.ItemsVenda;

@Dao
public interface ItemsVendaDao {
    @Insert
    long insert(ItemsVenda itemsVenda);

    @Update
    int update(ItemsVenda itemsVenda);

    @Delete
    int delete(ItemsVenda itemsVenda);

    @Query("SELECT * FROM items_venda")
    List<ItemsVenda> getAll();

    @Query("SELECT * FROM items_venda WHERE id = :id")
    ItemsVenda getById(int id);
}
