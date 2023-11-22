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
import unipar.invictus.app.entity.ItensVenda;

public class ItensVendaDao implements GenericDao<ItensVenda> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String nomeTabela = "itensvenda";
    private String[] colunas = {"id", "idVenda", "idProduto", "quantidade"};
    private Context context;
    private static ItensVendaDao instancia;

    public static ItensVendaDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new ItensVendaDao(context);
        } else {
            return instancia;
        }
    }

    public ItensVendaDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public @Nullable ItensVenda insert(ItensVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getIdVenda());
            valores.put(colunas[2], obj.getIdProduto());
            valores.put(colunas[3], obj.getQuantidade());

            long insertResult = database.insert(nomeTabela, null, valores);
            if (insertResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + insertResult, null, null, null, null);

                if (cursor.moveToFirst()) {
                    ItensVenda itensVenda = new ItensVenda();
                    itensVenda.setId(cursor.getInt(0));
                    itensVenda.setIdVenda(cursor.getInt(1));
                    itensVenda.setIdProduto(cursor.getInt(2));
                    itensVenda.setQuantidade(cursor.getInt(3));

                    cursor.close();

                    return itensVenda;
                }
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.insert(): " + ex.getMessage());
        }
        return null;
    }

    @Override
    public @Nullable ItensVenda update(ItensVenda obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getIdVenda());
            valores.put(colunas[2], obj.getIdProduto());
            valores.put(colunas[3], obj.getQuantidade());

            String[] identificador = {String.valueOf(obj.getId())};
            long updateResult = database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);

            if (updateResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + identificador[0], null, null, null, null);

                if (cursor.moveToFirst()) {
                    ItensVenda itensVenda = new ItensVenda();
                    itensVenda.setId(cursor.getInt(0));
                    itensVenda.setIdVenda(cursor.getInt(1));
                    itensVenda.setIdProduto(cursor.getInt(2));
                    itensVenda.setQuantidade(cursor.getInt(3));

                    cursor.close();

                    return itensVenda;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.update(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public long delete(ItensVenda obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};
            return database.delete(nomeTabela, colunas[0] + " = ?",
                    identificador);

        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.delete(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<ItensVenda> getAll() {
        ArrayList<ItensVenda> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    ItensVenda itensVenda = new ItensVenda();
                    itensVenda.setIdVenda(cursor.getInt(1));
                    itensVenda.setIdProduto(cursor.getInt(2));
                    itensVenda.setQuantidade(cursor.getInt(3));

                    lista.add(itensVenda);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public ItensVenda getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            Cursor cursor = database.query(nomeTabela, colunas,
                    colunas[0] + " = " + id, null,
                    null, null, null);

            if (cursor.moveToFirst()) {
                ItensVenda itensVenda = new ItensVenda();
                itensVenda.setId(cursor.getInt(0));
                itensVenda.setIdVenda(cursor.getInt(1));
                itensVenda.setIdProduto(cursor.getInt(2));
                itensVenda.setQuantidade(cursor.getInt(3));

                return itensVenda;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.getById(): " + ex.getMessage());
        }

        return null;
    }

    public ArrayList<ItensVenda> getByIdVenda(int idVenda) {
        ArrayList<ItensVenda> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    "idVenda = " + idVenda, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    ItensVenda itensVenda = new ItensVenda();
                    itensVenda.setId(cursor.getInt(0));
                    itensVenda.setIdVenda(cursor.getInt(1));
                    itensVenda.setIdProduto(cursor.getInt(2));
                    itensVenda.setQuantidade(cursor.getInt(3));

                    lista.add(itensVenda);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ItensVendaDao.getByIdVenda(): " + ex.getMessage());
        }
        return lista;
    }
}
