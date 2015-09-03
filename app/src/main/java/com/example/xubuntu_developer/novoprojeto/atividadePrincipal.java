package com.example.xubuntu_developer.novoprojeto;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("deprecation")
public class atividadePrincipal extends ActionBarActivity {


    private ArrayAdapter<String> mAdaptador;
    private String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_principal);

        Intent intent = getIntent();
        tipo = intent.getStringExtra(Intent.EXTRA_TEXT);

         //Transforma dados em uma lista
        List<String> previsao = new ArrayList<>();


        //Cria o Adptador
        mAdaptador = new ArrayAdapter<>(
                getApplicationContext(), // Contexto atual
                R.layout.item_lista_principal, // Nome do ID do layout
                R.id.item_texto, // ID do TextView a ser preenchido
                previsao);

        // Conecta a lista ao adaptador
        ListView listView = (ListView) findViewById(R.id.lista_principal);
        listView.setAdapter(mAdaptador);

        listView.setOnItemClickListener(new ItemClicado());
    }


    @Override
        protected void onStart() {
                super.onStart();
                atualizar();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividade_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {

            case R.id.action_settings:
                return true;

            case R.id.action_refresh:
                atualizar();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void atualizar() {
        PegaDadosDoServidor pega = new PegaDadosDoServidor();
        pega.execute();
    }

    public class PegaDadosDoServidor extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... voids) {
            ServidorFalso servidor = new ServidorFalso();
            return servidor.pegaDados(tipo);
        }

        @Override
               protected void onPostExecute(String[] result) {
                        if (result != null) {
                                mAdaptador.clear();
                               for(String r : result) {
                                       mAdaptador.add(r);
                }
            }
        }
    }

        //sub classe para dar função ao click
    private class ItemClicado implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            Toast.makeText(getApplicationContext(),
                    mAdaptador.getItem(position),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
