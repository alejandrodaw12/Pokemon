package com.example.pokemon.repositories.tareas;

import com.example.pokemon.clases.Cartas;
import com.example.pokemon.repositories.CartasRepository;

import java.util.concurrent.Callable;

public class TareaBorrarCartas implements Callable<Boolean> {
    private Cartas c = null;

    public TareaBorrarCartas(Cartas c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            CartasRepository.mCartasDao.delete(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
