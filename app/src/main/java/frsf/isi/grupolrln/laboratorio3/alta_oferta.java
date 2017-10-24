package frsf.isi.grupolrln.laboratorio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class alta_oferta extends AppCompatActivity {

    private Spinner sp_monedas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_oferta);

        sp_monedas = (Spinner) findViewById(R.id.sp_moneda);




    }
}
