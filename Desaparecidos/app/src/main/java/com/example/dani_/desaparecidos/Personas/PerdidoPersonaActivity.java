package com.example.dani_.desaparecidos.Personas;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.dani_.desaparecidos.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PerdidoPersonaActivity extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener{

    String Busqueda;
    String Provincia;
    String TipoFisico;
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
    GridView gridView;
    ArrayList<Personas> list;
    PersonasAdapterActivity adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_perdido);

        //navigation drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Perdido
        Intent mIntent = getIntent();

        Busqueda = mIntent.getStringExtra("Busqueda");
        Nombre = mIntent.getStringExtra("Nombre");
        Apellido = mIntent.getStringExtra("Apellido");
        Edad =mIntent.getStringExtra("Edad");
        Genero = mIntent.getStringExtra("Genero");
        Piel = mIntent.getStringExtra("Piel");
        Altura = mIntent.getStringExtra("Altura");
        Peso =mIntent.getStringExtra("Peso");
        ColorCabello = mIntent.getStringExtra("ColorCabello");
        ColorOjos = mIntent.getStringExtra("ColorOjos");
        FechaDesaparicion = mIntent.getStringExtra("FechaDesaparicion");
        Provincia = mIntent.getStringExtra("Provincia");
        TipoFisico = mIntent.getStringExtra("TipoFisico");
        Peligroso = mIntent.getStringExtra("Peligroso");


        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new PersonasAdapterActivity(this, R.layout.personasconfiguracion, list);
        gridView.setAdapter(adapter);

        BDUsuarios resg = new BDUsuarios(this, "BDUsuarios", null, 1);
        final SQLiteDatabase bd = resg.getReadableDatabase();

        //Obtener todos los datos de la base de datos


          if(Busqueda !=null) {

          Cursor cursor = bd.rawQuery("SELECT * FROM Personas WHERE Nombre LIKE '"+Nombre+"%' AND Apellidos LIKE '"+Apellido+"%' AND Edad LIKE '"+Edad+"%' AND " +
                    "Genero LIKE '"+Genero+"%' AND Piel LIKE '"+Piel+"%' AND Altura LIKE '"+Altura+"%' AND Peso LIKE '"+Peso+"%' AND ColorCabello LIKE '"+ColorCabello+"%'" +
                      " AND ColorOjos LIKE '"+ColorOjos+"%' AND FechaDesaparicion LIKE '"+FechaDesaparicion+"%' AND Provincia LIKE '"+Provincia+"%' AND TipoFisico LIKE '" +
                      ""+TipoFisico+"%' AND Peligroso LIKE '"+Peligroso+"%'", null);

              list.clear();
          while (cursor.moveToNext()) {
              String Nombre = cursor.getString(0);
              String Apellidos = cursor.getString(1);
              String Edad = cursor.getString(2);
              String Genero = cursor.getString(3);
              String Piel = cursor.getString(4);
              String Altura = cursor.getString(5);
              String Peso = cursor.getString(6);
              String ColorCabello = cursor.getString(7);
              String ColorOjos = cursor.getString(8);
              String FechaDesaparicion = cursor.getString(9);
              String Provincia = cursor.getString(10);
              String TipoFisico = cursor.getString(11);
              String Peligroso = cursor.getString(12);
              byte[] Imagen = cursor.getBlob(13);
              Double Latitud = cursor.getDouble(14);
              Double Longitud = cursor.getDouble(15);

              list.add(new Personas(Nombre, Apellidos, Edad, Genero,Piel, ColorCabello,ColorOjos,Provincia,TipoFisico,Peligroso,Altura,Peso,FechaDesaparicion,Imagen,Latitud,Longitud));
          }
              adapter.notifyDataSetChanged();

       }else{

         Cursor cursor2 =bd.rawQuery("SELECT * FROM Personas",null);
              list.clear();

          while (cursor2.moveToNext()) {
              String Nombre = cursor2.getString(0);
              String Apellidos = cursor2.getString(1);
              String Edad = cursor2.getString(2);
              String Genero = cursor2.getString(3);
              String Piel = cursor2.getString(4);
              String Altura = cursor2.getString(5);
              String Peso = cursor2.getString(6);
              String ColorCabello = cursor2.getString(7);
              String ColorOjos = cursor2.getString(8);
              String FechaDesaparicion = cursor2.getString(9);
              String Provincia = cursor2.getString(10);
              String TipoFisico = cursor2.getString(11);
              String Peligroso = cursor2.getString(12);
              byte[] Imagen = cursor2.getBlob(13);
              Double Latitud = cursor2.getDouble(14);
              Double Longitud = cursor2.getDouble(15);

              list.add(new Personas(Nombre, Apellidos, Edad, Genero,Piel, ColorCabello,ColorOjos,Provincia,TipoFisico,Peligroso,Altura,Peso,FechaDesaparicion,Imagen,Latitud,Longitud));
          }
              adapter.notifyDataSetChanged();
      }



    }

    ImageView imageViewFood;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewFood.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        int id=item.getItemId();


        if(id == R.id.action_listar){
            startActivity(new Intent(this,BusquedaPersonaActivity.class));

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

        if (id == R.id.nav_home) {
            Intent MiIntent = new Intent(PerdidoPersonaActivity.this,ElegirActivity.class);
            startActivity(MiIntent);
        } else if (id == R.id.nav_mapa) {
            Intent MiIntent = new Intent(PerdidoPersonaActivity.this,PersonasMapsActivity.class);
            MiIntent.putExtra("Todos","Si");
            startActivity(MiIntent);
        } else if (id == R.id.nav_cerrasesion) {
            Intent MiIntent = new Intent(PerdidoPersonaActivity.this,LoginActivity.class);
            startActivity(MiIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}





