package com.example.pokemon.Clases;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.R;

import java.util.List;


public class ListaCartasAdapter extends RecyclerView.Adapter<CartasViewHolder> {

    private Context c;
    private List<Cartas> listaCartas;
    private LayoutInflater mInflater;

    public ListaCartasAdapter(Context c) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
    }

    public ListaCartasAdapter(Context c, List<Cartas> listaCartas) {
        this.c = c;
        this.listaCartas = listaCartas;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_lista_carta, parent, false);
        return new CartasViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {
        if(listaCartas!=null) {
            Cartas cartaActual = listaCartas.get(position);
            holder.txt_rv_nombrec.setText("Ciudad: " + cartaActual.getNombre());
            holder.txt_rv_tipo.setText("Tipo: " + cartaActual.getTipo());
            holder.txt_rv_nombre_ataque.setText("Nombre Ataque: " + cartaActual.getNombre_ataque());
            holder.txt_rv_desAtaque.setText("Descripcion Ataque: " + cartaActual.getDesAtaque());
            holder.txt_rv_debilidad.setText("Debilidad: " + cartaActual.getDebilidad());
        }
    }

    @Override
    public int getItemCount() {
        if (listaCartas != null)
            return listaCartas.size();
        else return 0;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public List<Cartas> getListaCartas() {
        return listaCartas;
    }

    public void setListaCiudades(List<Cartas> listaCartas) {
        this.listaCartas = listaCartas;
        if(this.listaCartas == null)
        {
           Log.i("ciudades","la lista ciudades es nulo");
        }
        else{
            for(Cartas c:listaCartas)
            {
                Log.i("ciudades","ciudad -> " + c.getNombre());
            }
        }
        notifyDataSetChanged();
    }
}