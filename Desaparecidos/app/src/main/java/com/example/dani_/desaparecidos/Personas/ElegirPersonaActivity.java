package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dani_.desaparecidos.R;

public class ElegirPersonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_elegir);
        Button Perdido = (Button) findViewById(R.id.Perdido);
        Button Encontrado = (Button) findViewById(R.id.Encontrado);




        Perdido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirPersonaActivity.this,PerdidoPersonaActivity.class);

                startActivity(intent);
            }
        });

        Encontrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ElegirPersonaActivity.this,EncontradoPersonaActivity.class);

                startActivity(intent);
            }
        });
    }
}


