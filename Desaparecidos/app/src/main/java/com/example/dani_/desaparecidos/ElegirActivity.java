package com.example.dani_.desaparecidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dani_.desaparecidos.Animales.ElegirAnimalActivity;
import com.example.dani_.desaparecidos.Personas.ElegirPersonaActivity;

public class ElegirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir);
        Button personas = (Button) findViewById(R.id.Personas);
        Button animales = (Button) findViewById(R.id.Animales);



        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirActivity.this,ElegirPersonaActivity.class);
                startActivity(intent);
            }
        });

        animales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirActivity.this,ElegirAnimalActivity.class);
                startActivity(intent);
            }
        });
    }
}

