package com.example.invictus.app.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.invictus.app.dao.ClienteDao;
import com.example.invictus.app.entity.Cliente;

@Database(entities = {Cliente.class}, version = 1)
public abstract class InvictusDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();
}
