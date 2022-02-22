package com.example.pokemon.tareas;

import androidx.lifecycle.LiveData;


import com.example.pokemon.Clases.Cartas;
import com.example.pokemon.repositories.repositories.repositories.CartasRepository;

import java.util.List;
import java.util.concurrent.Callable;


public class TareaMostrarCartas implements Callable<LiveData<List<Cartas>>> {
    @Override
    public LiveData<List<Cartas>> call() throws Exception {
        try{
            LiveData<List<Cartas>> carta = CartasRepository.mDAOCartas.cogerTodasCartas();
            return carta;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
