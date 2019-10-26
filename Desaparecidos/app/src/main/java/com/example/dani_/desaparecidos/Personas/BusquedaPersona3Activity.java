package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dani_.desaparecidos.R;

public class BusquedaPersona3Activity extends AppCompatActivity {

    String Nombre;
    String Apellido;
    String Edad;
    String Genero;
    String Piel;
    String Altura;
    String Peso;
    String ColorCabello;
    String ColorOjos;
    String FechaDesaparicion;
    EditText Provincia;
    Spinner TipoFisico;
    Spinner Peligroso;
    Button Registrar;
    String tipos;
    String peligrosos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_busqueda3);

        Intent mIntent = getIntent();
        Nombre = mIntent.getStringExtra("Nombre");
        Apellido = mIntent.getStringExtra("Apellido");
        Edad = mIntent.getStringExtra("Edad");
        Genero = mIntent.getStringExtra("Genero");
        Piel =mIntent.getStringExtra("Piel");
        Altura = mIntent.getStringExtra("Altura");
        Peso = mIntent.getStringExtra("Peso");
        ColorCabello = mIntent.getStringExtra("ColorCabello");
        ColorOjos = mIntent.getStringExtra("ColorOjos");
        FechaDesaparicion = mIntent.getStringExtra("FechaDesaparicion");

        Provincia = (EditText)findViewById(R.id.Provincia2);
        TipoFisico = (Spinner)findViewById(R.id.TipoFisico);
        Peligroso = (Spinner)findViewById(R.id.Peligroso2);
        Registrar = (Button)findViewById(R.id.Siguiente);

        tipos =TipoFisico.getSelectedItem().toString();
        peligrosos =Peligroso.getSelectedItem().toString();



        Registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent miIntent = new Intent(BusquedaPersona3Activity.this,PerdidoPersonaActivity.class);


                miIntent.putExtra("Provincia",Provincia.getText().toString());
                miIntent.putExtra("TipoFisico",tipos);
                miIntent.putExtra("Peligroso",peligrosos);
                miIntent.putExtra("Altura",Altura);
                miIntent.putExtra("ColorCabello",ColorCabello);
                miIntent.putExtra("ColorOjos",ColorOjos);
                miIntent.putExtra("FechaDesaparicion",FechaDesaparicion);
                miIntent.putExtra("Nombre",Nombre);
                miIntent.putExtra("Apellido",Apellido);
                miIntent.putExtra("Edad",Edad);
                miIntent.putExtra("Genero",Genero);
                miIntent.putExtra("Piel",Piel);
                miIntent.putExtra("Peso",Peso);
                miIntent.putExtra("Busqueda","si");

                startActivity(miIntent);

        }





});


}}