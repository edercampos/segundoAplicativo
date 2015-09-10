package com.example.xubuntu_developer.novoprojeto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xubuntu-developer on 9/10/15.
 */
public class AlunoDBHelper extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    public static final String NOME_BANCO = "aluno.db";

    public AlunoDBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE = "CREATE TABLE " + contratoDB.Aluno.NOME_TABELA + " (" +
                contratoDB.Aluno._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                contratoDB.Aluno.COLUNA_DATA + " INTEGER NOT NULL, " +
                contratoDB.Aluno.COLUNA_TIPO + " TEXT NOT NULL, " +
                contratoDB.Aluno.COLUNA_MENSAGEM + " TEXT NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + contratoDB.Aluno.NOME_TABELA);
        onCreate(sqLiteDatabase);
    }
}
