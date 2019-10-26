package com.example.dani_.desaparecidos.Animales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dani_.desaparecidos.R;

public class BusquedaAnimalActivity extends AppCompatActivity {
    String Tipos;
    String Tamanos;
    String Generos;

    EditText Nombre;
    Spinner Tipo;
    EditText ColorPelo;
    EditText Raza;
    Spinner Tamano;
    Spinner Genero;
    EditText FechaDesaparicion;
    Button Siguiente;
    String tipos;
    String tamanios;
    String generos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_busqueda);

        Nombre = (EditText) findViewById(R.id.Nombre);
        Tipo = (Spinner)findViewById(R.id.Tipo);
        ColorPelo = (EditText) findViewById(R.id.ColorPelo);
        Raza = (EditText) findViewById(R.id.Raza);
        Tamano = (Spinner) findViewById(R.id.Tamano);
        Genero = (Spinner) findViewById(R.id.Genero);
        FechaDesaparicion = (EditText)findViewById(R.id.FechaDesaparicion);
        Siguiente = (Button)findViewById(R.id.Siguiente);


        tipos = Tipo.getSelectedItem().toString();
        tamanios = Tamano.getSelectedItem().toString();
        generos =Genero.getSelectedItem().toString();


       Siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent miIntent = new Intent(BusquedaAnimalActivity.this,PerdidoAnimalActivity.class);


                miIntent.putExtra("Nombre",Nombre.getText().toString());
                miIntent.putExtra("Tipo",tipos);
                miIntent.putExtra("ColorPelo",ColorPelo.getText().toString());
                miIntent.putExtra("Raza",Raza.getText().toString());
                miIntent.putExtra("Tamano",tamanios);
                miIntent.putExtra("Genero",generos);
                miIntent.putExtra("FechaDesaparicion",FechaDesaparicion.getText().toString());
                miIntent.putExtra("Busqueda","si");

                startActivity(miIntent);

            }





        });


    }}