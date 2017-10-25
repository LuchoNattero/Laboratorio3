package frsf.isi.grupolrln.laboratorio3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class alta_oferta extends AppCompatActivity implements View.OnClickListener{

    private Spinner sp_monedas;
    private Spinner sp_cantegoria;
   // private Button bt_cancelar, bt_confirmar;
    private EditText hora,fecha,oferta,paga_hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_oferta);

/*        bt_cancelar = (Button) findViewById(R.id.bt_cancelar);
        bt_confirmar = (Button) findViewById(R.id.bt_guardar);*/

        hora = (EditText) findViewById(R.id.et_horas);
        fecha = (EditText) findViewById(R.id.et_fecha_fin);
        oferta = (EditText) findViewById(R.id.et_oferta);
        paga_hora = (EditText) findViewById(R.id.et_horas_cobrar);

        findViewById(R.id.bt_cancelar).setOnClickListener(this);
        findViewById(R.id.bt_guardar).setOnClickListener(this);


        sp_monedas = (Spinner) findViewById(R.id.sp_moneda);
        ArrayAdapter adp_array = ArrayAdapter.createFromResource(this,R.array.tipo_moneda,android.R.layout.simple_spinner_item);
        adp_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_monedas.setAdapter(adp_array);

        sp_cantegoria = (Spinner) findViewById(R.id.sp_categoria);
        ArrayAdapter<String> adp_categoria = new ArrayAdapter(this,android.R.layout.simple_spinner_item, (Categoria.CATEGORIAS_MOCK)); //no muestra bien
        adp_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_cantegoria.setAdapter((SpinnerAdapter) adp_categoria);



    }


    @Override
    public void onClick(View view) {

        boolean error = false;
        switch (view.getId()){

            case R.id.bt_guardar:

                if(oferta.getText().toString().isEmpty())
                {
                    oferta.setError("Debe completar el campo");
                    error = true;
                }
/*                if(paga_hora.getText().toString().isEmpty())
                {
                    paga_hora.setError("Debe completar el campo");
                    error = true;
                }
                if(fecha.getText().toString().isEmpty())
                {
                    fecha.setError("Debe completar el campo");
                    error = true;
                }
                if(hora.getText().toString().isEmpty())
                {
                    hora.setError("Debe completar el campo");
                    error = true;
                }
                if(!error)
                {

                    try{
                        SimpleDateFormat simpleDate = new SimpleDateFormat("yy/MM/dd");
                        Date date = simpleDate.parse(fecha.getText().toString());
                        //tarjeta.setFechaVencimiento(date);
                    }catch(ParseException ex){
                        fecha.setError("El formato debe ser yy/MM/dd");
                    }

                    Toast toast = Toast.makeText(getApplicationContext(), "Se hizo algo ", Toast.LENGTH_SHORT);
                    toast.show();
                }*/

                if(!error)
                {
                    String oferta_text = oferta.getText().toString();
                    Intent intent = getIntent();
                    intent.putExtra("nueva_oferta",oferta_text);
                    setResult(RESULT_OK,intent);
                    finish();
                }
                break;

            case R.id.bt_cancelar:

                setResult(RESULT_CANCELED);
                finish();
                break;
        }


    }
}
