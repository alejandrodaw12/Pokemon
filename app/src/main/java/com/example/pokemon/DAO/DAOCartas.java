package com.example.pokemon.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pokemon.Clases.Cartas;

@Dao
public interface DAOCartas {

    @Insert
    void insert(Cartas carta);

    @Query("DELETE FROM cartas")
    void deleteAll();
}
