package com.example.pokemon.repositories.repositories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pokemon.R;


public class CrearCartaActivity extends AppCompatActivity {

    EditText txt_nombre;
    EditText txt_tipo;
    EditText txt_ataque;
    EditText txt_descripcion;
    EditText txt_debilidada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carta);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_tipo = (EditText) findViewById(R.id.txt_tipo);
        txt_ataque = (EditText) findViewById(R.id.txt_nombreataque);
        txt_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        txt_debilidada = (EditText) findViewById(R.id.txt_debilidad);


    }

    public void crear(View view) {

    }
}