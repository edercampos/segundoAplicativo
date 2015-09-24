package com.example.xubuntu_developer.novoprojeto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;


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
                   Long.parseLong(id)
            };


            TextView detailTextView = (TextView) findViewById(R.id.detalhe_item_texto);

            detailTextView.setText(Long.toString(id));

            TextView detailText_data = (TextView) findViewById(R.id.text_data);

            detailTextView.setText(Long.toString(id));

            TextView detailText_situacao = (TextView) findViewById(R.id.text_Posicao);

            detailTextView.setText(Long.toString(id));

            TextView detailText_mensagem = (TextView) findViewById(R.id.text_Mensagem);

            detailTextView.setText(Long.toString(id));
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
