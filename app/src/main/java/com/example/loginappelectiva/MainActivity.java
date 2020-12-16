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

    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button ButtonInicio;
    private TextView miSalida;

    private ArrayList<Usuario> ListaUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.ini();
    }
    public void ini ()
    {
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById((R.id.editTextTextPassword));
        ButtonInicio = (Button) findViewById(R.id.ButtonInicio);
        ButtonInicio.setOnClickListener(this);
        miSalida = (TextView)findViewById(R.id.txt_salida);
    }
    private void llenarUsuarios()
    {
        ListaUsuario = new ArrayList<Usuario>();
        ListaUsuario.add(new Usuario("Saskia", "Garcia","saskia03garcia@gmail.com","12345"));
    }
    private void iniciarSesion()
    {
        llenarUsuarios();
        String correo = editTextTextEmailAddress.getText().toString();
        String contrasena =editTextTextPassword.getText().toString();

        boolean usuarioEncontrado = false;

        for (int i =0; i<ListaUsuario.size(); i++)
        {
            if (correo.equals(ListaUsuario.get(i).getCorreo()) && contrasena.equals(ListaUsuario.get(i).getContrasena()))
            {
                //Toast.makeText(this, "Bienvenido " +  ListaUsuario.get(i).getNombre(),Toast.LENGTH_SHORT).show();
                miSalida.setText("Bienvenido ");
                usuarioEncontrado = true;
                Intent inicio = new Intent(MainActivity.this, InicioMainActivity.class);
                startActivity(inicio);
            }
            else if(correo.isEmpty() || contrasena.isEmpty())
            {
                //Toast.makeText(this, "Llene los campos" ,Toast.LENGTH_SHORT).show();
                miSalida.setText("Llene los campos");
            }
            else
            {
               // Toast.makeText(this, "USUARIO NO ENCONTRADO" ,Toast.LENGTH_SHORT).show();
                miSalida.setText("USUARIO NO ENCONTRADO");
            }
        }


    }
    @Override
    public void onClick(View v) {

            this.iniciarSesion();

    }

    }
