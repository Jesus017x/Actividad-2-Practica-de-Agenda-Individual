package com.example.appagenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterEstudiantes
        extends RecyclerView.Adapter<AdapterEstudiantes.ViewHolderEstudiantes>
        implements View.OnClickListener{

    ArrayList<EstudiantesListados> listaEstudiantes;
    private View.OnClickListener listener;

    public AdapterEstudiantes(@NonNull ArrayList<EstudiantesListados> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @NonNull
    @Override
    public ViewHolderEstudiantes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,
                null, false);

        view.setOnClickListener(this);
        return new ViewHolderEstudiantes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEstudiantes holder, int position) {
        holder.nombre.setText(listaEstudiantes.get(position).getNombre());
        holder.info.setText(listaEstudiantes.get(position).getInfo());
        holder.foto.setImageResource(listaEstudiantes.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaEstudiantes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolderEstudiantes extends RecyclerView.ViewHolder {

        TextView nombre, info;
        ImageView foto;

        public ViewHolderEstudiantes(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            info = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);


        }

    }
}
