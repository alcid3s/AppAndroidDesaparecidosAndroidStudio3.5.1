package com.example.dani_.desaparecidos.Animales;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.dani_.desaparecidos.BDUsuarios;
import com.example.dani_.desaparecidos.ElegirActivity;
import com.example.dani_.desaparecidos.LoginActivity;
import com.example.dani_.desaparecidos.Personas.BusquedaPersonaActivity;
import com.example.dani_.desaparecidos.Personas.PersonasMapsActivity;
import com.example.dani_.desaparecidos.Personas.PerdidoPersonaActivity;
import com.example.dani_.desaparecidos.Personas.Personas;
import com.example.dani_.desaparecidos.Personas.PersonasAdapterActivity;
import com.example.dani_.desaparecidos.R;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PerdidoAnimalActivity  extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener{

    String Busqueda;
    String Nombre;
    String Tipo;
    String ColorPelo;
    String Raza;
    String Tamano;
    String Genero;
    String FechaDesaparicion;

    GridView gridView;
    ArrayList<Animales> list;
    AnimalesAdapterActivity adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_perdido);

        //navigation drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Perdido
        Intent mIntent = getIntent();

        Busqueda = mIntent.getStringExtra("Busqueda");
        Nombre = mIntent.getStringExtra("Nombre");
        Tipo = mIntent.getStringExtra("Tipo");
        ColorPelo = mIntent.getStringExtra("ColorPelo");
        Raza = mIntent.getStringExtra("Raza");
        Genero = mIntent.getStringExtra("Genero");
        Tamano = mIntent.getStringExtra("Tamano");
        FechaDesaparicion = mIntent.getStringExtra("FechaDesaparicion");



        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new AnimalesAdapterActivity(this, R.layout.animalesconfiguracion, list);
        gridView.setAdapter(adapter);

        BDUsuarios resg = new BDUsuarios(this, "BDUsuarios", null, 1);
        SQLiteDatabase bd = resg.getReadableDatabase();
        //0btiene los datos de la base de datos



        if(Busqueda !=null) {

          //Obtiene los datos de los animales con los filtros de la busqueda
         Cursor cursor = bd.rawQuery("SELECT * FROM Animales WHERE Nombre LIKE '"+Nombre+"%' AND Tipo LIKE '"+Tipo+"%' AND ColorPelo LIKE '"+ColorPelo+"%' AND Raza LIKE " +
                    "'"+Raza+"%' AND Tamano LIKE '"+Tamano+"%' AND Genero LIKE '%"+Genero+"%' AND FechaDesaparicion LIKE '%"+FechaDesaparicion+"%'", null);
            list.clear();
            while (cursor.moveToNext()) {
                String Nombre = cursor.getString(0);
                String Tipo = cursor.getString(1);
                String ColorPelo = cursor.getString(2);
                String Raza = cursor.getString(3);
                String Tamano = cursor.getString(4);
                String Genero = cursor.getString(5);
                String FechaDesaparicion = cursor.getString(6);
                byte[] Imagen = cursor.getBlob(7);
                Double Latitud = cursor.getDouble(8);
                Double Longitud = cursor.getDouble(9);

                list.add(new Animales(Nombre,Tipo,ColorPelo,Raza,Tamano,Genero,FechaDesaparicion,Imagen,Latitud,Longitud));
            }
            adapter.notifyDataSetChanged();


        }else{

            //Obtiene todos los datos de animales
        Cursor cursor2 = bd.rawQuery("SELECT * FROM Animales",null);
            list.clear();
            while (cursor2.moveToNext()) {
                String Nombre = cursor2.getString(0);
                String Tipo = cursor2.getString(1);
                String ColorPelo = cursor2.getString(2);
                String Raza = cursor2.getString(3);
                String Tamano = cursor2.getString(4);
                String Genero = cursor2.getString(5);
                String FechaDesaparicion = cursor2.getString(6);
                byte[] Imagen = cursor2.getBlob(7);
                Double Latitud = cursor2.getDouble(8);
                Double Longitud = cursor2.getDouble(9);

                list.add(new Animales(Nombre, Tipo, ColorPelo, Raza,Tamano,Genero,FechaDesaparicion,Imagen,Latitud,Longitud));
            }
            adapter.notifyDataSetChanged();
        }





    }




    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        int id=item.getItemId();


        if(id == R.id.action_listar){
            startActivity(new Intent(this,BusquedaAnimalActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }



    //navigation drawer

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//Si le das a home te lleva a elegir
        if (id == R.id.nav_home) {
            Intent MiIntent = new Intent(PerdidoAnimalActivity.this,ElegirActivity.class);
            startActivity(MiIntent);
            //Si le das al mapa te lleva al mapa de los animales
        } else if (id == R.id.nav_mapa) {
            Intent MiIntent = new Intent(PerdidoAnimalActivity.this,AnimalesMapsActivity.class);
            MiIntent.putExtra("Todos","Si");
            startActivity(MiIntent);
            //Si le das a cerrar sesion te lleva al login
        } else if (id == R.id.nav_cerrasesion) {
            Intent MiIntent = new Intent(PerdidoAnimalActivity.this,LoginActivity.class);
            startActivity(MiIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}






