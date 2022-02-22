package com.example.pokemon.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.pokemon.DAO.DAOCartas;


@Database(entities = {DAOCartas.class}, version = 1, exportSchema = false)
public abstract class CartasRoomDatabase extends RoomDatabase {
    public abstract DAOCartas cartasDao();
    private static CartasRoomDatabase INSTANCE;
    public static CartasRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CartasRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CartasRoomDatabase.class, "ciudad_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
