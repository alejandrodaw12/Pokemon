package com.example.pokemon.repositories.repositories.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;


import com.example.pokemon.Clases.Cartas;
import com.example.pokemon.DAO.DAOCartas;
import com.example.pokemon.roomDatabase.CartasRoomDatabase;
import com.example.pokemon.tareas.TareaBorrarCartas;
import com.example.pokemon.tareas.TareaInsertarCarta;
import com.example.pokemon.tareas.TareaObtenerCartas;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CartasRepository {
    public static DAOCartas mDAOCartas;
    private LiveData<List<Cartas>> mAllcartas;

    public CartasRepository(Application application) {
        CartasRoomDatabase db =  CartasRoomDatabase.getDatabase(application);
        mDAOCartas = db.cartasDao();
        mAllcartas= mDAOCartas.cogerTodasCartas();
    }

    public LiveData<List<Cartas>> getmAllcartas()
    {
        return mAllcartas;
    }


    public static boolean insertarCartas(Cartas c) {
        FutureTask t = new FutureTask(new TareaInsertarCarta(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    //---------------------------------------------------------------------------

    public static LiveData<List<DAOCartas>> obtenerCartas()
    {
        LiveData<List<DAOCartas>> cartasDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerCartas());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cartasDevueltas= (LiveData<List<DAOCartas>>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cartasDevueltas;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarCartas(Cartas c) {
        FutureTask t = new FutureTask(new TareaBorrarCartas(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }

}
