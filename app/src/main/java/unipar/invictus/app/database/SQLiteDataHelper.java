package unipar.invictus.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE clientes (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "email TEXT," +
                        "documento TEXT)"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE produtos (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "cod INTEGER," +
                        "descricao TEXT," +
                        "valorUnitario REAL," +
                        "qtdEstoque INTEGER)"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE usuarios (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "email TEXT," +
                        "senha TEXT)"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE vendas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "clienteId INTEGER," +
                        "valorTotal REAL)"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE itensvenda (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "idVenda INTEGER," +
                        "idProduto INTEGER," +
                        "quantidade INTEGER)"
        );

        seedClientes(sqLiteDatabase);
        seedProdutos(sqLiteDatabase);
        seedUsuarios(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    private void seedClientes(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("nome", "Elivaldo");
        values.put("email", "elivaldo@example.com");
        values.put("documento", "123456789");
        db.insert("clientes", null, values);

        values.clear();

        values.put("nome", "Paranaíbo");
        values.put("email", "paranaibo@example.com");
        values.put("documento", "987654321");
        db.insert("clientes", null, values);
    }

    private void seedProdutos(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("cod", 1);
        values.put("descricao", "Água de Batata");
        values.put("valorUnitario", 19.99);
        values.put("qtdEstoque", 100);
        db.insert("produtos", null, values);

        values.clear();

        values.put("cod", 2);
        values.put("descricao", "Vela do Monza 92");
        values.put("valorUnitario", 29.99);
        values.put("qtdEstoque", 50);
        db.insert("produtos", null, values);
    }

    private void seedUsuarios(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("nome", "Cristyan");
        values.put("email", "cristyan@example.com");
        values.put("senha", "123");
        db.insert("usuarios", null, values);

        values.clear();

        values.put("nome", "Gustavo");
        values.put("email", "gustavo@example.com");
        values.put("senha", "123");
        db.insert("usuarios", null, values);
    }
}
