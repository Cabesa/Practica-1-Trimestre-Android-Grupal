package com.example.aleja.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Fotos extends AppCompatActivity {
    public ImageView imgFotos;
    public String restaurante;
    public TextView txtFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);
        txtFoto=(TextView)findViewById(R.id.txtFoto);
        setTitle(getIntent().getStringExtra("Restaurante"));

        imgFotos = (ImageView) findViewById(R.id.imgFoto);
        switch (getIntent().getStringExtra("Restaurante")) {
            case "Centro":
                restaurante="centro";
                imgFotos.setImageResource(R.drawable.centro1);
                break;
            case "Alcalá de Guadaira":
                restaurante="alcala";
                imgFotos.setImageResource(R.drawable.alcala1);
                break;
            case "Marbella":
                restaurante="marbella";
                imgFotos.setImageResource(R.drawable.marbella1);
                break;
        }

    }
    public void pulsarFoto(View v)
    {
        String numero=txtFoto.getText().toString().trim();
        numero=numero.substring(0,1);
        int num=Integer.parseInt(numero)+1;
        if(num<=3) {
            String restActual = restaurante + num;
            int resID = getResources().getIdentifier(restActual, "drawable", "com.example.aleja.proyecto");
            imgFotos.setImageResource(resID);
            txtFoto.setText(num + "/3");
        }else{
            String restActual = restaurante + 1;
            int resID = getResources().getIdentifier(restActual, "drawable", "com.example.aleja.proyecto");
            imgFotos.setImageResource(resID);
            txtFoto.setText("1/3");
        }
    }
}
