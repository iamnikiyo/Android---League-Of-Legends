package bynikiyo.sdowlol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.MasteryPage;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class masteries_list extends AppCompatActivity {
        private ListView listaAndroid;

        private String reg,summonerName;
        private ArrayAdapter adapter;
        private ArrayList listName = new ArrayList();
        private Summoner summoner;
        private MasteryPages p;
        private Set<MasteryPage> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masteries_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        summonerName = getIntent().getExtras().getString("summonerName");
        reg = getIntent().getExtras().getString("region");
        /**
         * Objeto para recibir los datos del summoner desde infoSummoner
         */

        RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");
        java.util.Map<String, Summoner> summoners = null;

        try {
            switch (reg) {
                case "EUW":
                    summoners = api.getSummonersByName(Region.EUW, summonerName);
                    summoner = summoners.get(summonerName);
                    MasteryPages p = api.getMasteryPages(Region.EUW, summoner.getId());
                     pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "NA":
                    summoners = api.getSummonersByName(Region.NA, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.NA, summoner.getId());
                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "BR":
                    summoners = api.getSummonersByName(Region.BR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.BR, summoner.getId());
                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "LAN":
                    summoners = api.getSummonersByName(Region.LAN, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.LAN, summoner.getId());
                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "KR":
                    summoners = api.getSummonersByName(Region.KR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.KR, summoner.getId());
                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "LAS":
                    summoners = api.getSummonersByName(Region.LAS, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.LAS, summoner.getId());
                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }

                    break;
                case "OCE":
                    summoners = api.getSummonersByName(Region.OCE, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.OCE, summoner.getId());

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "PBE":
                    summoners = api.getSummonersByName(Region.PBE, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.OCE, summoner.getId());

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "RU":
                    summoners = api.getSummonersByName(Region.RU, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.RU, summoner.getId());

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "TR":
                    summoners = api.getSummonersByName(Region.TR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.TR, summoner.getId());

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "GLOBAL":
                    summoners = api.getSummonersByName(Region.GLOBAL, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.GLOBAL, summoner.getId());

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;


            }


        }catch (RiotApiException e){

            e.printStackTrace();
        }







        listaAndroid = (ListView) findViewById(R.id.listNames);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listName);

        listaAndroid.setAdapter(adapter);

    }

}
