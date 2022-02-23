package com.example.pokemon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.viewModel.CartasViewModel;

import java.util.ArrayList;
import java.util.List;

public class BorrarCartaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp_borrarc = null;
    Cartas pseleccionada = null;
    ArrayAdapter<Cartas> adapter = null;
    ArrayList<Cartas> cartas = null;
    CartasViewModel mcartasViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_carta);
        sp_borrarc = (Spinner) findViewById(R.id.sp_borrarc);
        sp_borrarc.setOnItemSelectedListener(this);
        mcartasViewModel = ViewModelProviders.of(this).get(CartasViewModel.class);
        //-----------------------------------------------------------
        LiveData<List<Cartas>> cartasLive = mcartasViewModel.obtenerCartas();
        if(cartasLive != null) {
            cartasLive.observe(this, new Observer<List<Cartas>>() {
                @Override
                public void onChanged(@Nullable final List<Cartas> lascartas) {
                    asignarAdaptadorSpinnerCartas(lascartas);
                }
            });
        }
        else{
            Toast.makeText(this, "no se han recuperado cartas", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void asignarAdaptadorSpinnerCartas(List<Cartas> lascartas) {
        adapter = new ArrayAdapter<Cartas>(this , R.layout.item_cartas, lascartas);
        sp_borrarc.setAdapter(adapter);
    }

    public void borrarCarta(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("Quieres borrar la carta?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pseleccionada == null)
                {
                    mostrarToast("selecciona una carta");
                    return;
                }
                //borrar provincia
                boolean borradoOK = mcartasViewModel.borrarCartas(pseleccionada);
                if(borradoOK)
                {
                    mostrarToast("carta borrada correctamente");
                }
                else{
                    mostrarToast("la carta no se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Cartas c = (Cartas) sp_borrarc.getItemAtPosition(position);
        pseleccionada = c;
        //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
