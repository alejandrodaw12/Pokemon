package com.example.pokemon.Clases;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.repositories.repositories.MonstrarActivity;
import com.example.pokemon.R;

import java.util.List;


public class CartasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_OBJETO_CARTA =  "hola";
    public TextView txt_rv_nombrec = null;
    public TextView txt_rv_tipo = null;
    public TextView txt_rv_nombre_ataque = null;
    public TextView txt_rv_desAtaque = null;
    public TextView txt_rv_debilidad = null;
    final ListaCartasAdapter lcAdapter;

    public CartasViewHolder(@NonNull View itemView, ListaCartasAdapter mAdapter) {
        super(itemView);
        txt_rv_nombrec = (TextView)  itemView.findViewById(R.id.txt_nombre_poke);
        txt_rv_tipo = (TextView)  itemView.findViewById(R.id.txt_tipo_poke);
        txt_rv_nombre_ataque = (TextView)  itemView.findViewById(R.id.txt_nombreAtaque_poke);
        txt_rv_desAtaque = (TextView)  itemView.findViewById(R.id.txt_descripcion_poke);
        txt_rv_debilidad = (TextView)  itemView.findViewById(R.id.txt_debilidad_poke);
        this.lcAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int mPosition = getAdapterPosition();
        // int mPosition = getLayoutPosition();
        List<Cartas> cartas = this.lcAdapter.getListaCartas();
        Cartas carta = cartas.get(mPosition);
        lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getC(), MonstrarActivity.class);
        intent.putExtra(EXTRA_OBJETO_CARTA, carta);
        lcAdapter.getC().startActivity(intent);
    }
}
