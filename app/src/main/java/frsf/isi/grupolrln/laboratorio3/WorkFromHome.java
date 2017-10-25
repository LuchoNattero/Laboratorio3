package frsf.isi.grupolrln.laboratorio3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class WorkFromHome extends AppCompatActivity {

    private ListView lv_lista_trabajo;
    private Adaptador adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(WorkFromHome.this,alta_oferta.class);
                startActivityForResult(intent,1);
            }
        });

        lv_lista_trabajo = (ListView)findViewById(R.id.lv_primera_lista);
        List<Trabajo> listaTrabajos = new LinkedList<>(Arrays.asList(Trabajo.TRABAJOS_MOCK));
        adap = new Adaptador(this, listaTrabajos);
        lv_lista_trabajo.setAdapter(adap);
        registerForContextMenu(lv_lista_trabajo);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
/*    @Override
    public boolean onContextItemSelected(MenuItem item) {
    }*/

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

/*        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Trabajo trabajo = adap.getItem(info.position);*/
        Toast.makeText(getApplicationContext(), "Se hizo algo ", Toast.LENGTH_SHORT).show();

        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Accion");
        inflater.inflate(R.menu.menu_opciones, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.item_borrar:

                Toast.makeText(getApplicationContext(), "Se eliminó ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_postularse:

                Toast.makeText(getApplicationContext(), "Se postulo ", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String nueva_oferta = data.getExtras().getString("nueva_oferta");
                int id_trabajo = adap.getCount();
                Trabajo nuevo_trabajo = new Trabajo(id_trabajo, nueva_oferta);
                adap.addItem(nuevo_trabajo);
                adap.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "Se agrego correctamente la oferta", Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(getApplicationContext(), "Se cancelo el agregado de oferta", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
