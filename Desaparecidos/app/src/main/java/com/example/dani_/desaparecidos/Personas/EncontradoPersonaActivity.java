package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dani_.desaparecidos.R;

public class EncontradoPersonaActivity extends AppCompatActivity {
    String generos;
    public EditText Nombre;
    public EditText Apellido;
    public EditText Edad;
    public Spinner Genero;
    public EditText Piel;
    public Button Siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_encontrado);


            Nombre = (EditText)findViewById(R.id.Nombre);
            Apellido = (EditText)findViewById(R.id.Apellido);
            Edad = (EditText)findViewById(R.id.ColorPelo);
            Genero = (Spinner)findViewById(R.id.Genero);
            Piel = (EditText)findViewById(R.id.Raza);
            Siguiente = (Button)findViewById(R.id.Siguiente);



            Genero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> parent, View arg1,
                                           int pos, long arg3) {
                    generos = parent.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            Siguiente.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent miIntent = new Intent(EncontradoPersonaActivity.this,EncontradoPersona2Activity.class);


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


