package com.example.aleja.proyecto;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Productos extends AppCompatActivity {

    private String comidas[];
    private String descripciones[];
    private String ingredientesLista[];
    private String descripcionesLargas[];
    private Integer[] imgid={
            R.drawable.hamburguesa,
            R.drawable.ravioles,
            R.drawable.pizza,

    };
    public EditText txtBuscador;
    public TextView txtDescripcion;
    public ImageView imgPrincipal;
    private ListView lista;
    public TextView txtIngredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        txtBuscador =(EditText)findViewById(R.id.txtBuscador);
        comidas=getResources().getStringArray(R.array.opcionesLista);
        descripciones=getResources().getStringArray(R.array.descripcionesLista);
        descripcionesLargas=getResources().getStringArray(R.array.descripcionesLargas);
        ingredientesLista=getResources().getStringArray(R.array.ingredientes);
        ListAdapterPractica adapter=new ListAdapterPractica(this,comidas,descripciones,imgid);
        lista=(ListView)findViewById(R.id.listProductos);
        imgPrincipal=(ImageView)findViewById(R.id.imgProducto);
        txtDescripcion=(TextView)findViewById(R.id.txtDescripcion);
        txtIngredientes=(TextView)findViewById(R.id.txtIngredientes);
        txtDescripcion.setText(descripcionesLargas[0]);
        txtIngredientes.setText(ingredientesLista[0]);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem= comidas[+position];
                imgPrincipal.setImageResource(imgid[+position]);
                txtDescripcion.setText(descripcionesLargas[+position]);
                txtBuscador.setText(comidas[+position]);
                txtIngredientes.setText(ingredientesLista[+position]);
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void pulsarBuscador(View v)
    {
        String q = txtBuscador.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, q);
        startActivity(intent);
    }
}
