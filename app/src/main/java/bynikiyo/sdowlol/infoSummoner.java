package bynikiyo.sdowlol;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Map;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson.*;


import java.io.IOException;

public class infoSummoner extends AppCompatActivity implements View.OnClickListener {

    private EditText summonerName;
    private Button envio;
    private TextView info;
    private Button buttonMasteries,buttonRunes;
    private View horizontalButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_summoner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        envio = (Button) findViewById(R.id.envio);
        envio.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.envio) {
            // Hide de los elementos para obtener el summonerName
            summonerName = (EditText) findViewById(R.id.summonerName);
            info = (TextView) findViewById(R.id.insertar);
            info.setVisibility(View.INVISIBLE);
            envio.setVisibility(View.GONE);
            summonerName.setVisibility(View.INVISIBLE);
            envio.setVisibility(View.INVISIBLE);
            horizontalButtons = findViewById(R.id.horizontalButtons);
            horizontalButtons.setVisibility(View.VISIBLE);
            View vista = (View) findViewById(R.id.vista);
            vista.setVisibility(View.VISIBLE);
            buttonMasteries = (Button) findViewById(R.id.buttonMasteries);
            ListView lista = (ListView) findViewById(R.id.listView);
            // Obtencion de los datos




            // Set de los datos.
            RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");

            Map<String, Summoner> summoners = null;
            try {
                summoners = api.getSummonersByName(Region.EUW, summonerName.getText().toString());
            } catch (RiotApiException e) {
                e.printStackTrace();
            }
            Summoner summoner = summoners.get(summonerName.getText().toString());

            listData listaDatos = new listData();
            lista = listaDatos.getLista(summoner.getDataString());

            buttonMasteries.setOnClickListener(this);
        }// Fin envioClick

        if(v.getId() == R.id.buttonMasteries){
            //Define la actividad
            Intent i = new Intent(this, Masteries.class);

            //Inicia la actividad
            startActivity(i);


        }



    }





}
