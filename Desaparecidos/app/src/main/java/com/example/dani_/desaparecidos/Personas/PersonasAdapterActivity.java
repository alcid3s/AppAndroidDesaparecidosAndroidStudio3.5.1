package com.example.dani_.desaparecidos.Personas;

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

public class PersonasAdapterActivity extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Personas> PersonasLista;
    String longitud,latitud;

    public PersonasAdapterActivity(Context context, int layout, ArrayList<Personas> PersonasLista) {
        this.context = context;
        this.layout = layout;
        this.PersonasLista = PersonasLista;
    }

    @Override
    public int getCount() {
        return PersonasLista.size();
    }

    @Override
    public Object getItem(int position) {
        return PersonasLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView Imagen;
        TextView Nombre,Apellidos,Edad,Genero,Piel,ColorCabello,ColorOjos,Provincia,TipoFisico,Peligroso,Altura,Peso,FechaDesaparicion;
        Button button;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);


            holder.button = (Button) row.findViewById(R.id.boton);
            holder.Nombre = (TextView) row.findViewById(R.id.Nombre);
            holder.Apellidos = (TextView) row.findViewById(R.id.Apellidos);
            holder.Edad = (TextView)row.findViewById(R.id.Edad);
            holder.Genero = (TextView) row.findViewById(R.id.Genero);
            holder.Imagen = (ImageView) row.findViewById(R.id.Img);
            holder.Piel = (TextView) row.findViewById(R.id.Piel);
            holder.ColorCabello = (TextView) row.findViewById(R.id.ColorCabello);
            holder.ColorOjos = (TextView) row.findViewById(R.id.ColorOjos);
            holder.Provincia = (TextView) row.findViewById(R.id.Provincia);
            holder.TipoFisico = (TextView) row.findViewById(R.id.TipoFisico);
            holder.Peligroso = (TextView) row.findViewById(R.id.Peligroso);
            holder.Altura = (TextView) row.findViewById(R.id.Altura);
            holder.Peso = (TextView) row.findViewById(R.id.Peso);
            holder.FechaDesaparicion = (TextView) row.findViewById(R.id.FechaDesaparicion);

            row.setTag(holder);


        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Personas Personas = PersonasLista.get(position);
        Button button = (Button) row.findViewById(R.id.boton);
        latitud = Personas.getLatitud().toString();
        longitud = Personas.getLongitud().toString();

        holder.Nombre.setText(Personas.getNombre());
        holder.Apellidos.setText(Personas.getApellidos());
        holder.Edad.setText(Personas.getEdad());
        holder.Genero.setText(Personas.getGenero());
        holder.Piel.setText(Personas.getPiel());
        holder.ColorCabello.setText(Personas.getColorCabello());
        holder.ColorOjos.setText(Personas.getColorOjos());
        holder.Provincia.setText(Personas.getProvincia());
        holder.TipoFisico.setText(Personas.getTipoFisico());
        holder.Peligroso.setText(Personas.getPeligroso());
        holder.Altura.setText(Personas.getAltura());
        holder.Peso.setText(Personas.getPeso());
        holder.FechaDesaparicion.setText(Personas.getFechaDesaparicion());

        byte[] Imagen = Personas.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Imagen, 0, Imagen.length);
        holder.Imagen.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonasMapsActivity.class);
                intent.putExtra("latitud",latitud);
                intent.putExtra("longitud",longitud);
                intent.putExtra("busqueda","si");
                context.startActivity(intent);

            }
        });
        return row;
    }
}
