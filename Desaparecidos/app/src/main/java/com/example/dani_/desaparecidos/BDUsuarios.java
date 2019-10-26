package com.example.dani_.desaparecidos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.Date;

//Base de datos con los usuarios, las personas y los animales desaparecidos
public class BDUsuarios extends SQLiteOpenHelper {

    private String sentenciaSQL = "CREATE TABLE Usuarios (Nombres TEXT, contrasena TEXT);";
    private String sentenciaSQL2 = "INSERT INTO Usuarios VALUES ('admin','admin');";
    private String sentenciaSQL3 = "INSERT INTO Usuarios VALUES ('usuario1','usuario1');";
    private String sentenciaSQL4 = "CREATE TABLE Personas (Nombre TEXT,Apellidos TEXT,Edad TEXT,Genero TEXT,Piel TEXT,Altura TEXT,Peso TEXT,ColorCabello" +
    " Text,ColorOjos Text,FechaDesaparicion TEXT,Provincia Text,TipoFisico Text,Peligroso Text,Imagen BYTE[], Latitud Double, Longitud Double)";
    private String sentenciaSQL5 ="CREATE TABLE Animales (Nombre TEXT, Tipo TEXT, ColorPelo TEXT, " +
    "Raza TEXT, Tamano TEXT, Genero TEXT,FechaDesaparicion TEXT, Imagen BLOB, Latitud Double, Longitud Double)";

//Constructor
    public BDUsuarios(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "BDUsuarios", factory, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

//Modulo que crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
//Ejecuto las sentencias SQL
        db.execSQL(sentenciaSQL);
        db.execSQL(sentenciaSQL2);
        db.execSQL(sentenciaSQL3);
        db.execSQL(sentenciaSQL4);
        db.execSQL(sentenciaSQL5);


    }


    public void insertDataAnimales(String Nombre, String Tipo, String ColorPelo, String Raza, String Tamano,
         String Genero, String FechaDesaparicion, byte[] imagen, Double Latitud,Double Longitud){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Animales VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, Nombre);
        statement.bindString(2, Tipo);
        statement.bindString(3, ColorPelo);
        statement.bindString(4, Raza);
        statement.bindString(5, Tamano);
        statement.bindString(6, Genero);
        statement.bindString(7, FechaDesaparicion);
        statement.bindBlob(8, imagen);
        statement.bindDouble(9, Latitud);
        statement.bindDouble(10, Longitud);

        statement.executeInsert();
    }

    public void insertDataPersonas(String Nombre, String Apellidos, String Edad, String Genero, String Piel,
         String Altura, String Peso, String ColorCabello, String ColorOjos, String FechaDesaparicion,
         String Provincia, String TipoFisico, String Peligroso,byte[] Imagen, Double Latitud, Double Longitud ){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Personas VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, Nombre);
        statement.bindString(2, Apellidos);
        statement.bindString(3, Edad);
        statement.bindString(4, Genero);
        statement.bindString(5, Piel);
        statement.bindString(6, Altura);
        statement.bindString(7, Peso);
        statement.bindString(8, ColorCabello);
        statement.bindString(9, ColorOjos);
        statement.bindString(10, FechaDesaparicion);
        statement.bindString(11, Provincia);
        statement.bindString(12, TipoFisico);
        statement.bindString(13, Peligroso);
        statement.bindBlob(14, Imagen);
        statement.bindDouble(15, Latitud);
        statement.bindDouble(16, Longitud);

        statement.executeInsert();
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}