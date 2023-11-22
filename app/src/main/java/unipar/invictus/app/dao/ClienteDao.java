package unipar.invictus.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import unipar.invictus.app.dao.abstracts.IGenericDao;
import unipar.invictus.app.database.SQLiteDataHelper;
import unipar.invictus.app.entity.Cliente;

public class ClienteDao implements IGenericDao<Cliente> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String nomeTabela = "clientes";
    private String[] colunas = {"id", "nome", "email", "documento"};
    private Context context;
    private static ClienteDao instancia;

    public static ClienteDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new ClienteDao(context);
        } else {
            return instancia;
        }
    }

    public ClienteDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public @Nullable Cliente insert(Cliente obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getDocumento());
            long insertResult = database.insert(nomeTabela, null, valores);

            if (insertResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + insertResult, null, null, null, null);

                if (cursor.moveToFirst()) {
                    Cliente clienteInserido = new Cliente();
                    clienteInserido.setId(cursor.getInt(0));
                    clienteInserido.setNome(cursor.getString(1));
                    clienteInserido.setEmail(cursor.getString(2));
                    clienteInserido.setDocumento(cursor.getString(3));

                    cursor.close();

                    return clienteInserido;
                }
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.insert(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public @Nullable Cliente update(Cliente obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getDocumento());

            String[] identificador = {String.valueOf(obj.getId())};

            long updateResult = database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);

            if (updateResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + identificador[0], null, null, null, null);

                if (cursor.moveToFirst()) {
                    Cliente clienteInserido = new Cliente();
                    clienteInserido.setId(cursor.getInt(0));
                    clienteInserido.setNome(cursor.getString(1));
                    clienteInserido.setEmail(cursor.getString(2));
                    clienteInserido.setDocumento(cursor.getString(3));

                    cursor.close();

                    return clienteInserido;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.update(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public long delete(Cliente obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};
            return database.delete(nomeTabela, colunas[0] + " = ?",
                    identificador);

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.delete(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Cliente cliente = new Cliente();
                    cliente.setNome(cursor.getString(1));
                    cliente.setEmail(cursor.getString(2));
                    cliente.setDocumento(cursor.getString(3));

                    lista.add(cliente);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            return retrieveByCursor(0, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getById(): " + ex.getMessage());
        }

        return null;
    }

    public Cliente getByEmail(String email) {
        try {
            String[] identificador = new String[]{email};
            return retrieveByCursor(2, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getByEmail(): " + ex.getMessage());
        }

        return null;
    }

    public @Nullable Cliente getByDocumento(String documento) {
        try {
            String[] identificador = new String[]{documento};
            return retrieveByCursor(3, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getByDocumento(): " + ex.getMessage());
        }

        return null;
    }

    private @Nullable Cliente retrieveByCursor(
            int colNum,
            String[] params,
            String groupBy,
            String having,
            String orderBy
    ) {
        try {
            String selection = colunas[colNum] + " = ?";

            Cursor cursor = database.query(
                    nomeTabela,
                    colunas,
                    selection,
                    params,
                    groupBy,
                    having,
                    orderBy
            );

            if (cursor.moveToFirst()) {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setEmail(cursor.getString(2));
                cliente.setDocumento(cursor.getString(3));

                cursor.close();

                return cliente;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.retrieveByCursor(): " + ex.getMessage());
        }

        return null;
    }
}
