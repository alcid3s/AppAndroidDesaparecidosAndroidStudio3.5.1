package com.example.dani_.desaparecidos.Animales;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dani_.desaparecidos.BDUsuarios;
import com.example.dani_.desaparecidos.Personas.PerdidoPersonaActivity;
import com.example.dani_.desaparecidos.Personas.PersonasMapsActivity;
import com.example.dani_.desaparecidos.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class AnimalesMapsActivity extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;

    String Todos;
    Button atras;
    Double lat;
    Double longitude;
    byte[] Imagen;
    String Nombre;
    String Tipo;
    String ColorPelo;
    String Raza;
    String Tamano;
    String Genero;
    String FechaDesaparicion;
    String Busqueda;
    String Latitud;
    String Longitud;
    SQLiteDatabase bd;
    Cursor cursor;


    public static BDUsuarios sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_maps);

        atras = (Button)findViewById(R.id.bmapa);
        sqLiteHelper = new BDUsuarios(this, "BDUsuarios", null, 1);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent mIntent = getIntent();
        Busqueda = mIntent.getStringExtra("busqueda");
        Latitud = mIntent.getStringExtra("latitud");
        Longitud = mIntent.getStringExtra("longitud");
        Todos = mIntent.getStringExtra("Todos");

        Nombre = mIntent.getStringExtra("Nombre");
        Tipo = mIntent.getStringExtra("Tipo");
        ColorPelo = mIntent.getStringExtra("ColorPelo");
        Genero = mIntent.getStringExtra("Genero");
        Raza = mIntent.getStringExtra("Raza");
        Tamano = mIntent.getStringExtra("Tamano");
        FechaDesaparicion = mIntent.getStringExtra("FechaDesaparicion");
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


        if (Todos != null) {
            BDUsuarios resg = new BDUsuarios(this, "BDUsuarios", null, 1);
            bd = resg.getReadableDatabase();
//Selecciona las posiciones de los animales y crea los marcadores
            cursor = bd.rawQuery("SELECT Latitud, Longitud FROM Animales", null);


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


                    Intent miIntent = new Intent(AnimalesMapsActivity.this, PerdidoAnimalActivity.class);

                    sqLiteHelper.insertDataAnimales(
                            Nombre,
                            Tipo,
                            ColorPelo,
                            Raza,
                            Tamano,
                            Genero,
    FechaDesaparicion,
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
