package com.example.pokemon.repositories.tareas;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.repositories.CartasRepository;

import java.util.concurrent.Callable;

public class TareaInsertarCartas implements Callable<Boolean> {
    private Cartas c = null;

    public TareaInsertarCartas(Cartas c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            CartasRepository.mCartasDao.insert(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
