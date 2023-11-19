package com.example.invictus.app.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.invictus.app.entity.Cliente;

import java.util.List;

public interface ClienteDao {
    @Insert
    long insert(Cliente cliente);

    @Update
    int update(Cliente cliente);

    @Delete
    int delete(Cliente cliente);

    @Query("SELECT * FROM clientes")
    List<Cliente> getAll();

    @Query("SELECT * FROM clientes WHERE id = :id")
    Cliente getById(int id);
}
