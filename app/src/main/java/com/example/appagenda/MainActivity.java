package com.example.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity<string> extends AppCompatActivity {

    EditText campoUsuario, campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario = (EditText) findViewById(R.id.campoUsuario);
        campoPassword = (EditText) findViewById(R.id.campoPassword);

        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = ((EditText)findViewById(R.id.campoUsuario)).getText().toString();
                String password = ((EditText)findViewById(R.id.campoPassword)).getText().toString();

                if(user.equals("admin") && password.equals("1234")){
                    entrar();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });


    }
    private void entrar(){
        Intent newForm = new Intent(MainActivity.this, secondActivity.class);
        startActivity(newForm);
    }

    private void limpiar() {
        campoUsuario.getText().clear();
        campoPassword.getText().clear();
    }

}