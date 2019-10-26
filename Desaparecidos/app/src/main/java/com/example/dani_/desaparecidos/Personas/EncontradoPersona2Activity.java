package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dani_.desaparecidos.R;

public class EncontradoPersona2Activity extends AppCompatActivity {
    String Nombre;
    String Apellido;
    String Edad;
    String Genero;
    String Piel;
    public EditText Altura;
    public EditText Peso;
    public EditText ColorCabello;
    public EditText ColorOjos;
    public EditText FechaDesaparicion;
    public Button Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_encontrado2);



        Intent mIntent = getIntent();
        Nombre = mIntent.getStringExtra("Nombre");
        Apellido = mIntent.getStringExtra("Apellido");
        Edad = mIntent.getStringExtra("Edad");
        Genero = mIntent.getStringExtra("Genero");
        Piel =mIntent.getStringExtra("Piel");


        Altura = (EditText)findViewById(R.id.Altura);
        Peso = (EditText)findViewById(R.id.Peso);
        ColorCabello = (EditText)findViewById(R.id.Tamano);
        ColorOjos = (EditText) findViewById(R.id.ColorOjos);
        FechaDesaparicion = (EditText)findViewById(R.id.FechaDesaparicion);

        Registrar = (Button)findViewById(R.id.Siguiente);




        Registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent miIntent = new Intent(EncontradoPersona2Activity.this,EncontradoPersona3Activity.class);


                miIntent.putExtra("Altura",Altura.getText().toString());
                miIntent.putExtra("Peso",Peso.getText().toString());
                miIntent.putExtra("ColorCabello",ColorCabello.getText().toString());
                miIntent.putExtra("ColorOjos",ColorOjos.getText().toString());
                miIntent.putExtra("FechaDesaparicion",FechaDesaparicion.getText().toString());
                miIntent.putExtra("Nombre",Nombre);
                miIntent.putExtra("Apellido",Apellido);
                miIntent.putExtra("Edad",Edad);
                miIntent.putExtra("Genero",Genero);
                miIntent.putExtra("Piel",Piel);

                startActivity(miIntent);

            }
        });


    }
}

