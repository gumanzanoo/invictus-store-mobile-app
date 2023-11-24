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
import unipar.invictus.app.entity.Usuario;

public class UsuarioDao implements IGenericDao<Usuario> {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String nomeTabela = "usuarios";
    private String[] colunas = {"id", "nome", "email", "senha"};
    private Context context;
    private static UsuarioDao instancia;

    public static UsuarioDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new UsuarioDao(context);
        } else {
            return instancia;
        }
    }

    public UsuarioDao(Context context) {
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "InvictusDB",
                null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public @Nullable Usuario insert(Usuario obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getSenha());

            long insertResult = database.insert(nomeTabela, null, valores);

            if (insertResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + insertResult, null, null, null, null);

                if (cursor.moveToFirst()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(cursor.getInt(0));
                    usuario.setNome(cursor.getString(1));
                    usuario.setEmail(cursor.getString(2));

                    cursor.close();

                    return usuario;
                }
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "UsuarioDao.insert(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public @Nullable Usuario update(Usuario obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());
            valores.put(colunas[2], obj.getEmail());
            valores.put(colunas[3], obj.getSenha());

            String[] identificador = {String.valueOf(obj.getId())};
            long updateResult =  database.update(nomeTabela, valores,
                    colunas[0] + " = ?", identificador);

            if (updateResult != -1) {
                Cursor cursor = database.query(
                        nomeTabela, colunas, "id = " + identificador[0], null, null, null, null);

                if (cursor.moveToFirst()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(cursor.getInt(0));
                    usuario.setNome(cursor.getString(1));
                    usuario.setEmail(cursor.getString(2));

                    cursor.close();

                    return usuario;
                }
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "UsuarioDao.update(): " + ex.getMessage());
        }

        return null;
    }

    @Override
    public long delete(Usuario obj) {
        try {
            String[] identificador = {String.valueOf(obj.getId())};
            return database.delete(nomeTabela, colunas[0] + " = ?",
                    identificador);

        } catch (SQLException ex) {
            Log.e("ERRO", "UsuarioDao.delete(): " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Cursor cursor = database.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.setId(cursor.getInt(0));
                    usuario.setNome(cursor.getString(1));
                    usuario.setEmail(cursor.getString(2));
                    usuario.setSenha(cursor.getString(3));

                    lista.add(usuario);

                } while (cursor.moveToNext());
            }
        } catch (SQLException ex) {
            Log.e("ERRO", "UsuarioDao.getAll(): " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public Usuario getById(int id) {
        try {
            String[] identificador = {String.valueOf(id)};
            return retrieveByCursor(0, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getById(): " + ex.getMessage());
        }

        return null;
    }

    public Usuario getByEmail(String email) {
        try {
            String[] identificador = new String[]{email};
            return retrieveByCursor(2, identificador, null, null, null);
        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.getByEmail(): " + ex.getMessage());
        }

        return null;
    }

    private @Nullable Usuario retrieveByCursor(
            int colNum,
            String[]params,
            String groupBy,
            String having,
            String orderBy
    ) {
        try {
            String selection = colunas[colNum] + " = ?";
            Log.i("Invictus", selection);
            Log.i("Invictus", params[0]);
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
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(0));
                usuario.setNome(cursor.getString(1));
                usuario.setEmail(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));

                cursor.close();

                return usuario;
            }

        } catch (SQLException ex) {
            Log.e("ERRO", "ClienteDao.retrieveByCursor(): " + ex.getMessage());
        }

        return null;
    }
}
