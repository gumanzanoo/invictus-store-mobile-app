package unipar.invictus.app.database;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}