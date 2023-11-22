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

import unipar.invictus.app.dao.abstracts.GenericDao;
import unipar.invictus.app.database.SQLiteDataHelper;
import unipar.invictus.app.entity.Cliente;
import unipar.invictus.app.entity.Venda;

public class VendaDao implements GenericDao<Venda> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String nomeTabela = "vendas";
    private String[] colunas = {"id", "clienteId", "valorTotal"};
    private Context context;
    private static VendaDao instancia;

    public static VendaDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new VendaDao(context);
        } else {
            return instancia;
        }
    }

    public VendaDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public @Nullable Venda insert(Venda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getClienteId());
            valores.put(colunas[2], obj.getValorTotal());

            long insertResult = database.insert(nomeTabela, null, valores);

            if (insertResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + insertResult, null, null, null, null);

                if (cursor.moveToFirst()) {
                    Venda venda = new Venda();
                    venda.setId(cursor.getInt(0));
                    venda.setClienteId(cursor.getInt(1));
                    venda.setValorTotal(cursor.getDouble(2));

                    cursor.close();

                    return venda;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.insert(): " + ex.getMessage());
        }
        return null;
    }

    @Override
    public @Nullable Venda update(Venda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getClienteId());
            valores.put(colunas[2], obj.getValorTotal());

            String[] identificador = {String.valueOf(obj.getId())};
            long updateResult = database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);

            if (updateResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + identificador[0], null, null, null, null);

                if (cursor.moveToFirst()) {
                    Venda venda = new Venda();
                    venda.setId(cursor.getInt(0));
                    venda.setClienteId(cursor.getInt(1));
                    venda.setValorTotal(cursor.getDouble(2));

                    cursor.close();

                    return venda;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.update(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public long delete(Venda obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};
            return database.delete(nomeTabela, colunas[0] + " = ?",
                    identificador);

        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.delete(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Venda> getAll() {
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Venda venda = new Venda();
                    venda.setClienteId(cursor.getInt(1));
                    venda.setValorTotal(cursor.getDouble(2));

                    lista.add(venda);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public Venda getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            Cursor cursor = database.query(nomeTabela, colunas,
                    colunas[0] + " = " + id, null,
                    null, null, null);

            if (cursor.moveToFirst()) {
                Venda venda = new Venda();
                venda.setId(cursor.getInt(0));
                venda.setClienteId(cursor.getInt(1));
                venda.setValorTotal(cursor.getDouble(2));

                return venda;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.getById(): " + ex.getMessage());
        }

        return null;
    }

    public ArrayList<Venda> getByIdCliente(int idCliente) {
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    colunas[1] + " = " + idCliente, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Venda venda = new Venda();
                    venda.setId(cursor.getInt(0));
                    venda.setClienteId(cursor.getInt(1));
                    venda.setValorTotal(cursor.getDouble(2));

                    lista.add(venda);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "VendaDao.getByIdCliente(): " + ex.getMessage());
        }
        return lista;
    }
}
