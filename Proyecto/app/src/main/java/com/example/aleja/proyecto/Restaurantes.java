package com.example.aleja.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Restaurantes extends AppCompatActivity {

    private String restaurantes[];
    private Spinner lista;
    public ImageView imgCentral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);
        restaurantes = getResources().getStringArray(R.array.sevillaLista);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, restaurantes);
        lista=(Spinner)findViewById(R.id.spinRestaurantes);
        lista.setAdapter(spinnerArrayAdapter);
        imgCentral = (ImageView) findViewById(R.id.imgCentral);
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), lista.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                switch (lista.getSelectedItem().toString()) {
                    case "Centro":

                        imgCentral.setImageResource(R.drawable.centro1);
                        break;
                    case "Alcalá de Guadaira":

                        imgCentral.setImageResource(R.drawable.alcala1);
                        break;
                    case "Marbella":

                        imgCentral.setImageResource(R.drawable.marbella1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });


    }

    public void pulsarFotos(View v) {
        Intent i = new Intent(this, Fotos.class);
        i.putExtra("Restaurante", lista.getSelectedItem().toString());
        startActivity(i);
    }

    public void pulsarProductos(View v) {
        Intent i = new Intent(this, Productos.class);
        startActivity(i);
    }

    public void pulsarRadioButtons(View v) {
        RadioGroup rgProvincias = (RadioGroup) findViewById(R.id.rdgProvincias);
        switch (rgProvincias.getCheckedRadioButtonId()) {
            case R.id.rdbMalaga:
                restaurantes = getResources().getStringArray(R.array.malagaLista);
                lista.setAdapter(null);
                ArrayAdapter<String> spinnerMalaga = new ArrayAdapter<String>
                        (this, android.R.layout.simple_spinner_item, restaurantes);
                lista.setAdapter(spinnerMalaga);
                break;
            case R.id.rdbSevilla:
                restaurantes = getResources().getStringArray(R.array.sevillaLista);
                lista.setAdapter(null);
                ArrayAdapter<String> spinnerSevilla = new ArrayAdapter<String>
                        (this, android.R.layout.simple_spinner_item, restaurantes);
                lista.setAdapter(spinnerSevilla);
                break;
        }
    }
}