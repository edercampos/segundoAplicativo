package com.example.xubuntu_developer.novoprojeto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


@SuppressWarnings("deprecation")
public class detalhes extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();


        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            long id = intent.getLongExtra(Intent.EXTRA_TEXT, 0L);

            String whereClause = contratoDB.Aluno._ID + " =?";
            String[] whereArgs = new String[]{
                    Long.toString(id)

            };


            SQLiteOpenHelper dbHelper = new AlunoDBHelper(getApplicationContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            Cursor cursor = db.query(
                    contratoDB.Aluno.NOME_TABELA, // Tabela
                    null, // colunas (todas)
                    whereClause, // colunas para o where
                    whereArgs, // valores para o where
                    null, // group by
                    null, // having
                    null  // sort by
            );
            if (cursor.moveToNext()) {
                long data = cursor.getLong(cursor.getColumnIndex(contratoDB.Aluno.COLUNA_DATA));
                String titulo = cursor.getString(cursor.getColumnIndex(contratoDB.Aluno.COLUNA_TIPO));
                String texto = cursor.getString(cursor.getColumnIndex(contratoDB.Aluno.COLUNA_MENSAGEM));

                String dataBonita = new SimpleDateFormat("dd/MM/yyyy").format(new Date(data * 1000));


                TextView detailTextView = (TextView) findViewById(R.id.detalhe_item_texto);
                detailTextView.setText(Long.toString(id));

                TextView detailText_data = (TextView) findViewById(R.id.text_data);
                detailText_data.setText(dataBonita);

                TextView detailText_situacao = (TextView) findViewById(R.id.text_Posicao);
                detailText_situacao.setText(titulo);

                TextView detailText_mensagem = (TextView) findViewById(R.id.text_Mensagem);
                detailText_mensagem.setText(texto);
            }


        }
    }

    

    @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_detalhes, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
