package frsf.isi.grupolrln.laboratorio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class alta_oferta extends AppCompatActivity {

    private Spinner sp_monedas;
    private Spinner sp_cantegoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_oferta);

        sp_monedas = (Spinner) findViewById(R.id.sp_moneda);
        ArrayAdapter adp_array = ArrayAdapter.createFromResource(this,R.array.tipo_moneda,android.R.layout.simple_spinner_item);
        adp_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_monedas.setAdapter(adp_array);

        sp_cantegoria = (Spinner) findViewById(R.id.sp_categoria);
        ArrayAdapter<String> adp_categoria = new ArrayAdapter(this,android.R.layout.simple_spinner_item, (Categoria.CATEGORIAS_MOCK)); //no muestra bien
        adp_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_cantegoria.setAdapter(adp_categoria);

    }
}
