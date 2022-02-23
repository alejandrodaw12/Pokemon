package com.example.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.clases.ListaCartasAdapter;
import com.example.pokemon.viewModel.CartasViewModel;

import java.util.Collections;
import java.util.List;

public class MostrarCartasActivity extends AppCompatActivity{
    private static final int PETICION1 = 1;
    private RecyclerView mRecyclerView;
    private ListaCartasAdapter mAdapter;
    private List<Cartas> cartas;
    private List<Cartas> cartasIniciales;
    CartasViewModel mCartaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monstrar);

        mRecyclerView = findViewById(R.id.rv_cartas);
        mAdapter = new ListaCartasAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


       mCartaViewModel = ViewModelProviders.of(this).get(CartasViewModel.class);
        //-----------------------------------------------------------
        LiveData<List<Cartas>> cartasLive = mCartaViewModel.obtenerCartas();
        if(cartasLive != null) {
            cartasLive.observe(this, new Observer<List<Cartas>>() {
                @Override
                public void onChanged(@Nullable final List<Cartas> lascartas) {
                    // Update the cached copy of the words in the adapter.
                    cartas = lascartas;
                    cartasIniciales = lascartas;
                    mAdapter.setListaCartas(lascartas);
                }
            });
        }
        //------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(cartas, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    cartas.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    cartas.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PETICION1) {
            if (resultCode == RESULT_OK) {
                Cartas c = (Cartas) data.getSerializableExtra(NuevaCartasActivity.EXTRA_OBJETO_CARTAS);
                cartas.add(c);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(cartas.size());
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(cartas.size());
            }
        }
    }



    public void refrescarCartas(View view) {
        finish();
        startActivity(getIntent());
        // solucion temporal, cierro el activity y lo vuelvo a abrir
    }

}
