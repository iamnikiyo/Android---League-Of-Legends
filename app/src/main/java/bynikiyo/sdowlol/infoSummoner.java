package bynikiyo.sdowlol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.summoner.Summoner;

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

            // Obtencion de los datos

            TextView idSummoner = (TextView) findViewById(R.id.summonerId);
            TextView summonerLevel = (TextView) findViewById(R.id.summonerLevel);
            TextView summonerIcon = (TextView) findViewById(R.id.summonerProfileIcon);
            TextView title = (TextView) findViewById(R.id.titulo);


            // Set de los datos.


            try {
                String nombre = summonerName.getText().toString();
                String server = "euw";
                Summoner e = new Summoner(nombre, server);
                title.setText(e.getName());
                idSummoner.setText("ID: " + e.getId().toString());
                summonerLevel.setText("Nivel: " + e.getSummonerLevel().toString());
                summonerIcon.setText("Icono: " + e.getSummonerLevel().toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
