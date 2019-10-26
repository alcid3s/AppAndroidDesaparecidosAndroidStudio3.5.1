package com.example.dani_.desaparecidos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public EditText Usuario;
    public EditText Contrasena;
    public Button iniciar;
    public String usuarios;
    public String contrasenas;
    Cursor listaRegistros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Usuario = (EditText) findViewById(R.id.NombreEdit);
        Contrasena = (EditText)findViewById(R.id.ContrasenaEdit);
        iniciar = (Button)findViewById(R.id.iniciar);

        BDUsuarios resg = new BDUsuarios(this, "BDUsuarios", null, 1);
        final SQLiteDatabase bd = resg.getReadableDatabase();
        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                usuarios = Usuario.getText().toString();
                contrasenas = Contrasena.getText().toString();

//Busca si el usuario esta en la base de datos
                listaRegistros = bd.rawQuery("SELECT * FROM Usuarios WHERE Nombres = '"+usuarios+"' AND Contrasena = '"+contrasenas+"'"  , null);
                if (listaRegistros.moveToFirst()) {


                        //si es usuario normal va a la pantalla de usuarios
                        Intent   i = new Intent(getApplicationContext(), ElegirActivity.class);
                        i.putExtra("usuarios",usuarios);
                        i.putExtra("contrasenas",contrasenas);
                        startActivity(i);
                    }

                else{
                    //El usuario o la contraseña es incorrecta
                    Toast.makeText(getBaseContext(), "Sin usuario//sin contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

