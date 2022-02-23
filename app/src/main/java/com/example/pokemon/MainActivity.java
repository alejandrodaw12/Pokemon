package com.example.pokemon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crear(View view) {
        Intent intent = new Intent(this, NuevaCartasActivity.class);
        startActivity(intent);
    }

    public void borrarCarta(View view) {
        Intent intent = new Intent(this, BorrarCartaActivity.class);
        startActivity(intent);
    }
    /*
    public void actualizarProvincia(View view) {
        Intent intent = new Intent(this, Actualizar.class);
        startActivity(intent);
    }*/

    public void mostrarCarta(View view) {
        Intent intent = new Intent(this, MostrarCartasActivity.class);
        startActivity(intent);
    }

    public void editarCarta(View view) {
        Intent intent = new Intent(this, MostrarCartasActivity.class);
        startActivity(intent);
    }
}
