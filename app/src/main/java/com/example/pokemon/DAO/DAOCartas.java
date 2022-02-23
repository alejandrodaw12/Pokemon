package com.example.pokemon.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pokemon.clases.Cartas;

import java.util.List;

@Dao
public interface DAOCartas {

    @Insert
    void insert(Cartas cartas);

    @Delete
    void delete(Cartas cartas);

    @Query("DELETE FROM cartas")
    void deleteAll();

    @Update
    void update(Cartas cartas);
    /*
        @Update
        void update(List<Ciudad> ciudades);
    */
    @Query("SELECT * from cartas ORDER BY nombre ASC")
    LiveData<List<Cartas>> cogerTodasCartas();

    @Query("SELECT * FROM cartas WHERE nombre like :nombrec")
    LiveData<Cartas> CogerCiudad(String nombrec);
}
