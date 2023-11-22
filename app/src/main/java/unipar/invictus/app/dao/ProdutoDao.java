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
import unipar.invictus.app.entity.Produto;

public class ProdutoDao implements GenericDao<Produto> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String nomeTabela = "produtos";
    private String[] colunas = {"id", "cod", "descricao", "valorUnitario", "qtdEstoque"};
    private Context context;
    private static ProdutoDao instancia;

    public static ProdutoDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new ProdutoDao(context);
        } else {
            return instancia;
        }
    }

    public ProdutoDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public @Nullable Produto insert(Produto obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getCod());
            valores.put(colunas[2], obj.getDescricao());
            valores.put(colunas[3], obj.getValorUnitario());
            valores.put(colunas[4], obj.getQtdEstoque());

            long insertResult = database.insert(nomeTabela, null, valores);
            if (insertResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + insertResult, null, null, null, null);

                if (cursor.moveToFirst()) {
                    Produto produto = new Produto();
                    produto.setId(cursor.getInt(0));
                    produto.setCod(cursor.getInt(1));
                    produto.setDescricao(cursor.getString(2));
                    produto.setValorUnitario(cursor.getDouble(3));
                    produto.setQtdEstoque(cursor.getInt(4));

                    cursor.close();

                    return produto;
                }
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.insert(): " + ex.getMessage());
        }
        return null;
    }

    @Override
    public @Nullable Produto update(Produto obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getCod());
            valores.put(colunas[2], obj.getDescricao());
            valores.put(colunas[3], obj.getValorUnitario());
            valores.put(colunas[4], obj.getQtdEstoque());

            String[] identificador = {String.valueOf(obj.getId())};
            long updateResult = database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);

            if (updateResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + identificador[0], null, null, null, null);

                if (cursor.moveToFirst()) {
                    Produto produto = new Produto();
                    produto.setId(cursor.getInt(0));
                    produto.setCod(cursor.getInt(1));
                    produto.setDescricao(cursor.getString(2));
                    produto.setValorUnitario(cursor.getDouble(3));
                    produto.setQtdEstoque(cursor.getInt(4));

                    cursor.close();

                    return produto;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.update(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public long delete(Produto obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};
            return database.delete(nomeTabela, colunas[0] + " = ?",
                    identificador);

        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.delete(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Produto produto = new Produto();
                    produto.setCod(cursor.getInt(1));
                    produto.setDescricao(cursor.getString(2));
                    produto.setValorUnitario(cursor.getDouble(3));
                    produto.setQtdEstoque(cursor.getInt(4));

                    lista.add(produto);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public Produto getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            return retrieveByCursor(0, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.getById(): " + ex.getMessage());
        }

        return null;
    }

    public Produto getByCod(int cod) {
        try {
            String[] identificador = {String.valueOf(cod)};
            return retrieveByCursor(2, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.getByCod(): " + ex.getMessage());
        }

        return null;
    }

    private @Nullable Produto retrieveByCursor(
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
                Produto produto = new Produto();
                produto.setId(cursor.getInt(0));
                produto.setCod(cursor.getInt(1));
                produto.setDescricao(cursor.getString(2));
                produto.setValorUnitario(cursor.getDouble(3));
                produto.setQtdEstoque(cursor.getInt(4));

                cursor.close();

                return produto;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ProdutoDao.retrieveByCursor(): " + ex.getMessage());
        }

        return null;
    }
}
