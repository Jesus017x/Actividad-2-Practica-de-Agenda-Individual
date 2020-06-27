
package com.example.appagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {
    ArrayList<EstudiantesListados> listaEstudiantes;
    RecyclerView recyclerEstudiantes;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listaEstudiantes = new ArrayList<>();
        recyclerEstudiantes = (RecyclerView) findViewById(R.id.recyclerID);
        recyclerEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        try {
            llenarEstudiantes();
        } catch (ParseException e){
            e.printStackTrace();
        }

        AdapterEstudiantes adapter = new AdapterEstudiantes(listaEstudiantes);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Seleccion: " + listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view))
                        .getNombre(),Toast.LENGTH_SHORT).show();
                Intent newForm = new Intent(secondActivity.this, thirdActivity.class);
                utilidadesEstudiantes.estudiantes = listaEstudiantes.get(recyclerEstudiantes.getChildAdapterPosition(view));
                startActivity(newForm);
            }
        });
        recyclerEstudiantes.setAdapter(adapter);

    }

    private void llenarEstudiantes() throws ParseException {
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        listaEstudiantes.add(new EstudiantesListados(R.drawable.deryck_whibley, "Deryck Whibley", "Compositor, Sum 41" , "Masculino",formatoFecha.parse("21-03-1980"),"Canada"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.avril_lavigne, "Avril Lavigne", "Vocalista, Solista", "Femenino", formatoFecha.parse("27-09-1984"), "Canada"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.mike_shinoda, "Mike Shinoda", "Productor, Linkin Park", "Masculino", formatoFecha.parse("11-02-1977"), "Estados Unidos"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.dolores_riordan, "Dolores O'Riordan", "Vocalista, The Cranberries", "Femenino", formatoFecha.parse("06-09-1971"), "Irlanda"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.adam_gontier, "Adam Gontier", "Vocalista, Three Days Grace", "Masculino", formatoFecha.parse("25-05-1978"), "Canada"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.gerard_way, "Gerard Way", "Vocalista, My Chemical Romance", "Masculino", formatoFecha.parse("09-04-1977"), "Estados Unidos"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.amy_lee, "Amy Lee", "Compositora, Evanescence", "Femenino", formatoFecha.parse("13-12-1981"), "Estados Unidos"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.jared_leto, "Jared Leto", "Productor, 30 Seconds to Mars", "Masculino", formatoFecha.parse("26-12-1971"), "Estados Unidos"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.ben_burnley, "Benjamin Burnley", "Vocalista, Breaking Benjamin", "Masculino", formatoFecha.parse("10-03-1978"), "Estados Unidos"));
        listaEstudiantes.add(new EstudiantesListados(R.drawable.billie_joe_armstrong, "Billie Joe Armstrong", "Compositor, Green Day", "Masculino", formatoFecha.parse("17-02-1972"), "Estados Unidos"));
    }
}



