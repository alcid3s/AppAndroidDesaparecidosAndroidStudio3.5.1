package com.example.dani_.desaparecidos.Personas;



public class Personas {
    String Nombre, Apellidos, Genero, Piel, ColorCabello, ColorOjos, Provincia, TipoFisico, Peligroso, FechaDesaparicion, Altura, Peso, Edad;

    byte[] Imagen;
    Double Latitud, Longitud;

    public Personas(String nombre, String apellidos, String edad, String genero, String piel, String colorCabello,
                    String colorOjos, String provincia, String tipoFisico, String peligroso, String altura, String peso, String fechaDesaparicion,
                    byte[] imagen, Double latitud, Double longitud) {
        Nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
        Genero = genero;
        Piel = piel;
        ColorCabello = colorCabello;
        ColorOjos = colorOjos;
        Provincia = provincia;
        TipoFisico = tipoFisico;
        Peligroso = peligroso;
        Altura = altura;
        Peso = peso;
        FechaDesaparicion = fechaDesaparicion;
        Imagen = imagen;
        Latitud = latitud;
        Longitud = longitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getPiel() {
        return Piel;
    }

    public void setPiel(String piel) {
        Piel = piel;
    }

    public String getColorCabello() {
        return ColorCabello;
    }

    public String getColorOjos() {
        return ColorOjos;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getTipoFisico() {
        return TipoFisico;
    }

    public String getPeligroso() {
        return Peligroso;
    }

    public void setPeligroso(String peligroso) {
        Peligroso = peligroso;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getFechaDesaparicion() { return FechaDesaparicion;  }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] imagen) {
        Imagen = imagen;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }


}