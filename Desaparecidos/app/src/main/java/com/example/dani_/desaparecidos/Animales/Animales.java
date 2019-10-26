package com.example.dani_.desaparecidos.Animales;

//Clase Animales (define los datos de los animales)
public class Animales {
    String Nombre;
    String Tipo;
    String ColorPelo;
    String Raza;
    String Tamano;
    String Genero;
    String FechaDesaparicion;
    byte[] Imagen;
    Double Latitud, Longitud;

    //Constructor Animales
    public Animales(String nombre, String tipo, String colorPelo, String raza, String tamano,
        String genero, String fechaDesaparicion, byte[] imagen, Double latitud, Double longitud) {
        Nombre = nombre;
        Tipo = tipo;
        ColorPelo = colorPelo;
        Raza = raza;
        Tamano = tamano;
        Genero = genero;
        FechaDesaparicion = fechaDesaparicion;
        Imagen = imagen;
        Latitud = latitud;
        Longitud = longitud;
    }




//Get and Set
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getColorPelo() {
        return ColorPelo;
    }

    public void setColorPelo(String colorPelo) {
        ColorPelo = colorPelo;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String tamano) {
        Tamano = tamano;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getFechaDesaparicion() {
        return FechaDesaparicion;
    }

    public void setFechaDesaparicion(String fechaDesaparicion) {
        FechaDesaparicion = fechaDesaparicion;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] imagen) {
        Imagen = imagen;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }
}
