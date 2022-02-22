package com.example.pokemon.tareas;



import com.example.pokemon.Clases.Cartas;
import com.example.pokemon.DAO.DAOCartas;
import com.example.pokemon.repositories.repositories.repositories.CartasRepository;

import java.util.concurrent.Callable;


public class TareaBorrarCartas implements Callable<Boolean> {
    private Cartas c = null;

    public TareaBorrarCartas(Cartas c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            CartasRepository.mDAOCartas.delete(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
