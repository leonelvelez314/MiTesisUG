package com.example.loginappelectiva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.loginappelectiva.Modelo.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextTextPersonName,editTextTextPassword;
    private Button button;
    private TextView validation;

    private ArrayList<Usuario> ListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        validation = (TextView) findViewById(R.id.validation);
    }

    private void llenarUsuarios(){
        ListaUsuarios = new ArrayList<>();
        ListaUsuarios.add(new Usuario("Nathi","Bohorquez","nathalie.bohorquezc@ug.edu.ec","123456"));
        ListaUsuarios.add(new Usuario("Saskia","Garcia","saskia03garcia@gmail.com","12345"));

    }

    private void inicioSesion(){
        llenarUsuarios();
        String email = editTextTextPersonName.getText().toString();
        String password = editTextTextPassword.getText().toString();

        boolean usuarioEncontrado = false;

        for(int i = 0; i<ListaUsuarios.size() ;i++){
            if (email.equals(ListaUsuarios.get(i).getCorreo()) && password.equals(ListaUsuarios.get(i).getContrasena())){
                validation.setText("Bienvenido");
                usuarioEncontrado = true;
                Intent inicio = new Intent(MainActivity.this, InicioMainActivity.class);
                startActivity(inicio);
            }
            else if (email.isEmpty() || password.isEmpty()){
                validation.setText("Llene los campos");
            }

            else {
                validation.setText("Usuario Incorrecto");
            }
        }

    }

    @Override
    public void onClick(View v) {
        this.inicioSesion();
    }
}