package unipar.invictus.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import unipar.invictus.app.dao.abstracts.GenericDao;
import unipar.invictus.app.database.SQLiteDataHelper;
import unipar.invictus.app.entity.Cliente;

public class ClienteDao implements GenericDao<Cliente> {
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

    private ClienteDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Cliente obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getDocumento());

            return database.insert(nomeTabela, null, valores);

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.insert(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Cliente obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getDocumento());

            String[] identificador = {String.valueOf(obj.getId())};
            return database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);


        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.update(): " + ex.getMessage());
        }
        return 0;
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
            Cursor cursor = database.query(nomeTabela, colunas,
                    colunas[0] + " = " + id, null,
                    null, null, null);

            if (cursor.moveToFirst()) {
                Cliente aluno = new Cliente();
                aluno.setId(cursor.getInt(0));
                aluno.setNome(cursor.getString(1));
                aluno.setEmail(cursor.getString(2));
                aluno.setDocumento(cursor.getString(3));

                return aluno;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getById(): " + ex.getMessage());
        }

        return null;
    }
}
