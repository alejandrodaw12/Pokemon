package com.example.pokemon.repositories.tareas;

import androidx.lifecycle.LiveData;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.repositories.CartasRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class TareaObtenerCartas implements Callable<LiveData<List<Cartas>>> {
    @Override
    public LiveData<List<Cartas>> call() throws Exception {
        try{
            LiveData<List<Cartas>> cartas = CartasRepository.mCartasDao.cogerTodasCartas();
            return cartas;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
