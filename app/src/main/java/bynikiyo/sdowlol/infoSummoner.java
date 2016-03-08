package bynikiyo.sdowlol;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson.*;
import android.app.ListActivity;

import org.w3c.dom.Text;

import java.io.IOException;

public class infoSummoner extends AppCompatActivity implements View.OnClickListener {

    private EditText summonerName;
    private Button envio;
    private TextView info,regionText;
    private Button buttonMasteries,buttonRunes;
    private View horizontalButtons;

    private ArrayAdapter<String> adaptador;

    private Spinner region;
    private String reg;
    private Summoner summoner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_summoner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        getSupportActionBar().setTitle("Information of Summoner");
        /**
         * Setting region spinner options
         */
        region = (Spinner) findViewById(R.id.spinner);

                adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Region.getArrayRegion());
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                region.setAdapter(adaptador);

        /**
         * Setting onclick sending button
         */
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
            buttonRunes = (Button) findViewById(R.id.buttonRunes);
            region.setVisibility(View.INVISIBLE);
            regionText = (TextView) findViewById(R.id.RegionText);
            regionText.setVisibility(View.INVISIBLE);
            // Obtencion de los datos
            /**
             * Obtencion de la region del spinner
             */
                reg = region.getSelectedItem().toString().toUpperCase();

            // Set de los datos.
            RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");

                switch(reg){
                    case "EUW" :
                        api.setRegion(Region.EUW);
                        break;
                    case "NA":
                        api.setRegion(Region.NA);
                        break;
                    case "BR":
                        api.setRegion(Region.BR);
                        break;
                    case "LAN":
                        api.setRegion(Region.LAN);
                        break;
                    case "KR":
                        api.setRegion(Region.KR);
                        break;
                    case "LAS":
                        api.setRegion(Region.LAS);
                        break;
                    case "OCE":
                        api.setRegion(Region.OCE);
                        break;
                    case "PBE":
                        api.setRegion(Region.PBE);
                        break;
                    case "RU":
                        api.setRegion(Region.RU);
                        break;
                    case "TR":
                        api.setRegion(Region.TR);
                        break;
                    case "GLOBAL":
                        api.setRegion(Region.GLOBAL);
                        break;

                }

            try {
                summoner = null;

                try {
                    summoner = api.getSummonerByName(api.getRegion(),summonerName.getText().toString().replace(" ",""));
                } catch (RiotApiException e) {
                    e.printStackTrace();
                }


                buttonMasteries.setOnClickListener(this);
                buttonRunes.setOnClickListener(this);
            TextView summonerNB = (TextView) findViewById(R.id.summonerNameB);
                summonerNB.setText(summoner.getName());


            ImageView logo = (ImageView) findViewById(R.id.logoSB);
                String nombreImagen = "i" + String.valueOf(summoner.getProfileIconId());

                int res_imagen = this.getResources().getIdentifier("drawable/" + nombreImagen, null, this.getPackageName());
                logo.setImageResource(res_imagen);
            TextView level = (TextView) findViewById(R.id.level);

                level.setText("Level: "+String.valueOf(summoner.getSummonerLevel()));

               try {
                TextView elo = (TextView) findViewById(R.id.rank);
                   elo.setText(api.getLeagueBySummoner(api.getRegion(),summoner.getId()).get(0).getTier()+ " " + api.getLeagueEntryBySummoner(api.getRegion(),summoner.getId()).get(0).getEntries().get(0).getDivision());
                } catch (RiotApiException e) {
                    e.printStackTrace();
                }
                getSupportActionBar().setTitle(summoner.getName());
            }catch (NullPointerException e){
                AlertDialog alerta = new AlertDialog.Builder(this).create();
                alerta.setTitle("Error");
                alerta.setMessage("Wrong summoner name");
                alerta.show();
                    Intent d = new Intent(this, infoSummoner.class);
                    startActivity(d);
            }

        }// Fin envioClick

        if(v.getId() == R.id.buttonMasteries){
            //Define la actividad
            Intent i = new Intent(this, masteries_list.class);
                    i.putExtra("summonerName",summonerName.getText().toString());
                    i.putExtra("region",reg);

            //Inicia la actividad
            startActivity(i);


        }

        if(v.getId() == R.id.buttonRunes){

            //Define la actividad
            Intent i = new Intent(this, activity_Runes.class);
            i.putExtra("summonerId",summoner.getId());
            i.putExtra("region",reg);
            //Inicia la actividad
            startActivity(i);

        }



    }



}
