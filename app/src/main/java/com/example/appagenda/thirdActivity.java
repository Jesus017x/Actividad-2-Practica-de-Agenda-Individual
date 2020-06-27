
package com.example.appagenda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class thirdActivity extends AppCompatActivity {

    TextView nombre;
    ImageView foto;
    TextView info;
    TextView sexo;
    TextView fecha;
    TextView direccion;

    EstudiantesListados estudiantes = utilidadesEstudiantes.estudiantes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_list);

        nombre = (TextView) findViewById(R.id.idNombre);
        foto = (ImageView) findViewById(R.id.idImagen);
        info = (TextView) findViewById(R.id.idInfo);
        sexo = (TextView) findViewById(R.id.idSexo);
        fecha = (TextView) findViewById(R.id.idNacmimiento);
        direccion = (TextView) findViewById(R.id.idDireccion);

        nombre.setText(estudiantes.getNombre());
        foto.setImageResource(estudiantes.getFoto());
        info.setText(estudiantes.getInfo());
        sexo.setText(estudiantes.getSexo());
        setDate(fecha);
        direccion.setText(estudiantes.getDireccion());


    }

    private void setDate(TextView view) {
        Date nacimiento = estudiantes.getFecha();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaN = formatoFecha.format(nacimiento);
        view.setText(fechaN);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnVolver:
                finish();
                break;
            case R.id.btnMapa:
                String uri = "geo:0,0?q=" + utilidadesEstudiantes.estudiantes.getDireccion();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
                break;
            case R.id.btnAgendar:
                Date cumpleaños = utilidadesEstudiantes.estudiantes.getFecha();
                Date target = new Date((new Date()).getYear(), cumpleaños.getMonth(), cumpleaños.getDate());
                Intent callIntent = new Intent(Intent.ACTION_INSERT);
                callIntent.setType("vnd.android.cursor.item/event");
                callIntent.putExtra(CalendarContract.Events.TITLE, "Birthday");
                callIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, target.getTime());
                callIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                startActivity(callIntent);
                break;
        }
    }

}