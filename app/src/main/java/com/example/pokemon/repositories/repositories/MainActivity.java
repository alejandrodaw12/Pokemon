package com.example.pokemon.repositories.repositories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pokemon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearCarta(View view) {
        Intent intent = new Intent(this, CrearCartaActivity.class);
        startActivity(intent);
    }

    public void editarCarta(View view) {
        Intent intent = new Intent(this, EditarCartaActivity.class);
        startActivity(intent);
    }

    public void BorrarCarta(View view) {
        Intent intent = new Intent(this, BorrarCartaActivity.class);
        startActivity(intent);
    }

    public void monstrarCarta(View view) {
        Intent intent = new Intent(this, MonstrarActivity.class);
        startActivity(intent);
    }
}