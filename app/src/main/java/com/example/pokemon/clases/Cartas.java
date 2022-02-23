package com.example.pokemon.clases;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "cartas")
public class Cartas implements Serializable {

    //atributos ----------------------------------------------------
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idcarta")
    private int idcarta;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "tipo")
    private String tipo;

    @NonNull
    @ColumnInfo(name = "nombre_ataque")
    private String nombre_ataque;

    @NonNull
    @ColumnInfo(name = "descripcion_del_ataque")
    private String desAtaque;

    @NonNull
    @ColumnInfo(name = "debilidad")
    private String debilidad;

    public Cartas(int idcarta,@NonNull String nombre, @NonNull String tipo, @NonNull String nombre_ataque, @NonNull String desAtaque, @NonNull String debilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nombre_ataque = nombre_ataque;
        this.desAtaque = desAtaque;
        this.debilidad = debilidad;
    }


    public int getIdcarta() {
        return idcarta;
    }

    public void setIdcarta(int idcarta) {
        this.idcarta = idcarta;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getTipo() {
        return tipo;
    }

    public void setTipo(@NonNull String tipo) {
        this.tipo = tipo;
    }

    @NonNull
    public String getNombre_ataque() {
        return nombre_ataque;
    }

    public void setNombre_ataque(@NonNull String nombre_ataque) {
        this.nombre_ataque = nombre_ataque;
    }

    @NonNull
    public String getDesAtaque() {
        return desAtaque;
    }

    public void setDesAtaque(@NonNull String desAtaque) {
        this.desAtaque = desAtaque;
    }

    @NonNull
    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(@NonNull String debilidad) {
        this.debilidad = debilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartas cartas = (Cartas) o;
        return idcarta == cartas.idcarta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcarta);
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "idcarta=" + idcarta +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nombre_ataque='" + nombre_ataque + '\'' +
                ", desAtaque='" + desAtaque + '\'' +
                ", debilidad='" + debilidad + '\'' +
                '}';
    }
}
