package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dani_.desaparecidos.BDUsuarios;
import com.example.dani_.desaparecidos.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PersonasMapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    String Todos;
    Button atras;
    Double lat;
    Double longitude;
    byte[] Imagen;
    String Provincia;
    String TiposFisico;
    String Peligroso;
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
    String Busqueda;
    String Latitud;
    String Longitud;
    SQLiteDatabase bd;
    Cursor cursor;

    BDUsuarios basedatos= new BDUsuarios(this, "BDUsuarios", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapspersonas);

        atras = (Button)findViewById(R.id.bmapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent mIntent = getIntent();
        Busqueda = mIntent.getStringExtra("busqueda");
        Latitud = mIntent.getStringExtra("latitud");
        Longitud = mIntent.getStringExtra("longitud");
        Todos = mIntent.getStringExtra("Todos");

        Nombre = mIntent.getStringExtra("Nombre");
        Apellido = mIntent.getStringExtra("Apellido");
        Edad = mIntent.getStringExtra("Edad");
        Genero = mIntent.getStringExtra("Genero");
        Piel = mIntent.getStringExtra("Piel");
        Altura = mIntent.getStringExtra("Altura");
        Peso = mIntent.getStringExtra("Peso");
        ColorCabello = mIntent.getStringExtra("ColorCabello");
        ColorOjos = mIntent.getStringExtra("ColorOjos");
        FechaDesaparicion = mIntent.getStringExtra("FechaDesaparicion");
        TiposFisico = mIntent.getStringExtra("TipoFisico");
        Peligroso =mIntent.getStringExtra("Peligroso");
        Provincia = mIntent.getStringExtra("Provincia");
        Imagen = mIntent.getByteArrayExtra("Imagen");
        atras.setVisibility(View.GONE);

        atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               onBackPressed();

            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        BDUsuarios resg = new BDUsuarios(this, "BDUsuarios", null, 1);
        bd = resg.getReadableDatabase();

        if (Todos != null) {

            cursor = bd.rawQuery("SELECT Latitud, Longitud FROM Personas", null);


            while (cursor.moveToNext()) {
                Double Latitud = cursor.getDouble(0);
                Double Longitud = cursor.getDouble(1);


                final LatLng lugar = new LatLng(Latitud, Longitud);
                mMap.addMarker(new MarkerOptions().position(lugar).title(""));
            }
        }

        if(Busqueda != null) {
            final LatLng lugar = new LatLng(Double.parseDouble(Latitud), Double.parseDouble(Longitud));
            mMap.addMarker(new MarkerOptions().position(lugar).title(""));
            atras.setVisibility(View.VISIBLE);


        }else{
            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                lat = latLng.latitude;
                longitude = latLng.longitude;
                LatLng a = new LatLng(lat,longitude);

    mMap.addMarker(new MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono))
            .position(a).title("Desaparecido")
            .anchor(0.0f, 1.0f));

    Intent miIntent = new Intent(PersonasMapsActivity.this, PerdidoPersonaActivity.class);
                basedatos.insertDataPersonas(
                        Nombre,
                        Apellido,
                        Edad,
                        Genero,
                        Piel,
                        Altura,
                        Peso,
                        ColorCabello,
                        ColorOjos,
                        FechaDesaparicion,
                        Provincia,
                        TiposFisico,
                        Peligroso,
                        Imagen,
                        lat,
                        longitude

                );


    startActivity(miIntent);
}

        });}

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getApplicationContext(),"Desaparecido", Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }



    @Override
    public void onClick(View v) {

    }
}
