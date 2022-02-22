package com.example.pokemon.tareas;

import androidx.lifecycle.LiveData;


import com.example.pokemon.Clases.Cartas;
import com.example.pokemon.repositories.repositories.repositories.CartasRepository;

import java.util.List;
import java.util.concurrent.Callable;


public class TareaObtenerCartas implements Callable<LiveData<List<Cartas>>> {
    @Override
    public LiveData<List<Cartas>> call() throws Exception {
        try{
            LiveData<List<Cartas>> cartas1 = CartasRepository.mDAOCartas.cogerTodasCartas();
            return cartas1;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}