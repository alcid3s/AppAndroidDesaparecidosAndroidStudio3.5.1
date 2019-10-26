package com.example.dani_.desaparecidos.Animales;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.dani_.desaparecidos.R;

import java.util.ArrayList;
//Adaptador de animales
public class AnimalesAdapterActivity extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<Animales> AnimalesLista;
    String longitud;
    String latitud;

    public AnimalesAdapterActivity(Context context, int layout, ArrayList<Animales> animalesLista) {
        this.context = context;
        this.layout = layout;
        AnimalesLista = animalesLista;
    }

    @Override
    public int getCount() {
        return AnimalesLista.size();
    }

    @Override
    public Object getItem(int position) {
        return AnimalesLista.get(position);
    }

    //Los tipos de objetos para el adaptador
    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView Imagen;
        TextView Nombre,Tipo,ColorPelo,Raza,Tamano,Genero,FechaDesaparicion;
        Button button;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();
//La procedencia de los datos
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);


            holder.button = (Button) row.findViewById(R.id.boton);
            holder.Imagen = (ImageView)row.findViewById(R.id.Imagen);
            holder.Nombre = (TextView) row.findViewById(R.id.Nombre);
            holder.Tipo = (TextView) row.findViewById(R.id.Tipo);
            holder.ColorPelo = (TextView)row.findViewById(R.id.ColorPelo);
            holder.Raza = (TextView) row.findViewById(R.id.Raza);
            holder.Tamano = (TextView) row.findViewById(R.id.Tamano);
            holder.Genero= (TextView) row.findViewById(R.id.Genero);
            holder.FechaDesaparicion = (TextView)row.findViewById(R.id.FechaDesaparicion);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }



        Animales Animales = AnimalesLista.get(position);
        Button button = (Button) row.findViewById(R.id.boton);
        latitud = Animales.getLatitud().toString();
        longitud = Animales.getLongitud().toString();

        holder.Nombre.setText(Animales.getNombre());
        holder.Tipo.setText(Animales.getTipo());
        holder.ColorPelo.setText(Animales.getColorPelo());
        holder.Raza.setText(Animales.getRaza());
        holder.Genero.setText(Animales.getGenero());
        holder.Tamano.setText(Animales.getTamano());
        holder.FechaDesaparicion.setText(Animales.getFechaDesaparicion());

        byte[] Imagen = Animales.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Imagen, 0, Imagen.length);
        holder.Imagen.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AnimalesMapsActivity.class);
                intent.putExtra("latitud",latitud);
                intent.putExtra("longitud",longitud);
                intent.putExtra("busqueda","si");
                context.startActivity(intent);

            }
        });
        return row;
    }
}
