package com.example.invictus.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.invictus.app.dao.ClienteDao;
import com.example.invictus.app.entity.Cliente;
import com.example.invictus.app.entity.ItemsVenda;
import com.example.invictus.app.entity.Produto;
import com.example.invictus.app.entity.Venda;

@Database(entities = {
        Cliente.class,
        Produto.class,
        Venda.class,
        ItemsVenda.class
}, version = 1)

public abstract class InvictusDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();

    public abstract Produto produtoDao();

    public abstract Venda vendaDao();

    public abstract ItemsVenda itemsVendaDao();
}
