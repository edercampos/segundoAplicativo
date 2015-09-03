package com.example.xubuntu_developer.novoprojeto;

import android.content.Intent;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class codigo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        Button botao = (Button) findViewById(R.id.ok1);


        botao.setOnClickListener(new clique());
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_codigo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

// Funcionario

    private class clique implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            Intent detailIntent = new Intent(getApplication(), atividadePrincipal.class);

            EditText editText = (EditText) findViewById(R.id.editText);
            String pass = editText.getText().toString();

            if ("123".equals(pass)) {
                detailIntent.putExtra(Intent.EXTRA_TEXT, "aluno");
                startActivity(detailIntent);
            } else if ("456".equals(pass)) {
                detailIntent.putExtra(Intent.EXTRA_TEXT, "professor");
                startActivity(detailIntent);
            } else {
                Toast.makeText(getApplicationContext(),
                        "Senha inválida: ",
                        Toast.LENGTH_SHORT
                ).show();
            }



        }
    }


}
