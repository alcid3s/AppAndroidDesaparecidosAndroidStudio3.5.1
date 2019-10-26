package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dani_.desaparecidos.FiltroNumeros;
import com.example.dani_.desaparecidos.R;

public class BusquedaPersonaActivity extends AppCompatActivity {

String generos;
    public EditText Nombre;
    public EditText Apellido;
    public EditText Edad;
    public Spinner Genero;
    public EditText Piel;
    public Button Siguiente;
  //  final String[] generos = new String[]{"Masculino","Femenino"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_busqueda);

        Nombre = (EditText)findViewById(R.id.Nombre);
        Apellido = (EditText)findViewById(R.id.Apellido);
        Edad = (EditText)findViewById(R.id.Edad);
        Genero = (Spinner)findViewById(R.id.Genero);
        Piel = (EditText)findViewById(R.id.Piel);
        Siguiente = (Button)findViewById(R.id.Siguiente);


        Edad.setFilters(new InputFilter[]{ new FiltroNumeros(151)});

        generos =Genero.getSelectedItem().toString();

        Siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent miIntent = new Intent(BusquedaPersonaActivity.this,BusquedaPersona2Activity.class);


                miIntent.putExtra("Nombre",Nombre.getText().toString());
                miIntent.putExtra("Apellido",Apellido.getText().toString());
                miIntent.putExtra("Edad",Edad.getText().toString());
                miIntent.putExtra("Genero",generos);
                miIntent.putExtra("Piel",Piel.getText().toString());


                startActivity(miIntent);

            }
        });


    }
}