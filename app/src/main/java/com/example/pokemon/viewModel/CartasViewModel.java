package com.example.pokemon.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.repositories.CartasRepository;

import java.util.List;

public class CartasViewModel extends AndroidViewModel {
    private CartasRepository mRepository;
    private LiveData<List<Cartas>> mAllCartas;

    public CartasViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CartasRepository(application);
        mAllCartas = mRepository.getmAllcartas();
    }

    public LiveData<List<Cartas>> obtenerCartas()
    {
        LiveData<List<Cartas>> mAllCartas = mRepository.obtenerCartas();
        return mAllCartas;
    }

    public boolean insertarCarta(Cartas c)
    {
        boolean insercionOK = mRepository.insertarCartas(c);
        return insercionOK;
    }

    public  boolean borrarCartas(Cartas c)
    {
        boolean borradoOK = mRepository.borrarCartas(c);
        return borradoOK;
    }

    public  boolean actualizarCartas(Cartas c)
    {
        boolean actualizacionOK = mRepository.actualizarCartas(c);
        return actualizacionOK;
    }
}
