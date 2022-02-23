package com.example.pokemon;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.viewModel.CartasViewModel;

public class NuevaCartasActivity extends AppCompatActivity {

    public static final String EXTRA_OBJETO_CARTAS ="HOLA";
    EditText edt_nombre;
    EditText edt_id;
    EditText edt_tipo;
    EditText edt_nombreAtaque;
    EditText edt_descripcion;
    EditText edt_debilidad;
    CartasViewModel mCartasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carta);
        edt_nombre = findViewById(R.id.txt_id);
        edt_id = findViewById(R.id.txt_id);
        edt_tipo = findViewById(R.id.txt_tipo);
        edt_nombreAtaque = findViewById(R.id.txt_nombreataque);
        edt_descripcion = findViewById(R.id.txt_descripcion);
        edt_debilidad = findViewById(R.id.txt_debilidad);
        mCartasViewModel = ViewModelProviders.of(this).get(CartasViewModel.class);
        }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void crearCarta(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("quieres guardar la carta?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Cartas c = null;
                try{
                    int id = Integer.valueOf(String.valueOf(edt_id.getId()));
                    String nombre = String.valueOf(edt_nombre.getText());
                    String tipo = String.valueOf(edt_tipo.getText());
                    String nombreAtaque = String.valueOf(edt_nombreAtaque.getText());
                    String descripcion = String.valueOf(edt_descripcion.getText());
                    String debilidad = String.valueOf(edt_debilidad.getText());
                    c = new Cartas(id ,nombre, tipo, nombreAtaque, descripcion, debilidad);
                    boolean insercionOK = mCartasViewModel.insertarCarta(c);
                    if(insercionOK)
                    {
                        mostrarToast("Carta guardada correctamente");
                        Intent intent = new Intent();
                        intent.putExtra(EXTRA_OBJETO_CARTAS, c);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else
                    {
                        mostrarToast("no se pudo guardar la carta");
                    }
                }catch (Exception e)
                {
                    mostrarToast("error, revisa los datos introducidos");
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

}
