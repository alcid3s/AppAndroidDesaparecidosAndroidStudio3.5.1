package com.example.dani_.desaparecidos.Animales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dani_.desaparecidos.R;

public class ElegirAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_elegir);
        Button Perdido = (Button) findViewById(R.id.Perdido);
        Button Encontrado = (Button) findViewById(R.id.Encontrado);


//De elegir animal a perdido animal
        Perdido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirAnimalActivity.this,PerdidoAnimalActivity.class);
                startActivity(intent);
            }
        });
//de elegir animal a encontrado animal
        Encontrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirAnimalActivity.this,EncontradoAnimalActivity.class);
                startActivity(intent);
            }
        });
    }
}



