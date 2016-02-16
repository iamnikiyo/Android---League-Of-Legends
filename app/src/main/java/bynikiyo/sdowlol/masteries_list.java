package bynikiyo.sdowlol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Mastery;
import net.rithms.riot.dto.Summoner.MasteryPage;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import android.widget.AdapterView.*;
import android.widget.ViewFlipper;

public class masteries_list extends AppCompatActivity {
        private ListView listaAndroid;

        private String reg,summonerName;
        private ArrayAdapter adapter;
        private ArrayList listName = new ArrayList();
        private Summoner summoner;
        private MasteryPages p;
        private Set<MasteryPage> pages;
        private float init_x;
        private Map mapaMaestrias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masteries_list);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        setSupportActionBar(toolbar);
        flipper.setVisibility(View.INVISIBLE);

        /**
         * Getting data from infoSummoner Activity
         */
        summonerName = getIntent().getExtras().getString("summonerName");
        reg = getIntent().getExtras().getString("region");
        /**
         * Setting toolbar title
         */
        getSupportActionBar().setTitle("Mastery Pages");



        getListName();

        listaAndroid = (ListView) findViewById(R.id.listNames);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listName);
        listaAndroid.setAdapter(adapter);
        listaAndroid.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String value = (String)adapter.getItem(position);
                List<Mastery> lm = getListMastery(value);
                initializeImagesView();
                for(Mastery m:lm){
                    String nombreImagen = "m_" +String.valueOf(m.getId());
                    int res_imagen = masteries_list.this.getResources().getIdentifier("drawable/" + nombreImagen, null, masteries_list.this.getPackageName());

                   try {
                       getMasteryImageView(m.getId()).setImageResource(res_imagen);
                   }catch (NullPointerException ex){
                       ex.printStackTrace();

                   }

                }
                //------------------------------------------------------------------------
                listaAndroid.setVisibility(View.INVISIBLE);
                flipper.setVisibility(View.VISIBLE);

                flipper.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:
                                init_x = event.getX();
                                return true;
                            case MotionEvent.ACTION_UP:
                                float distance = init_x - event.getX();

                                if (distance < 0) {

                                    flipper.showPrevious();
                                }

                                if (distance > 0) {

                                    flipper.showNext();
                                }
                            default:
                                break;
                        }


                        return false;
                    }
                });


            }

                //-------------------






    });

}

    public List<Mastery> getListMastery(String value){
        List<Mastery> masteries;
        for(MasteryPage e: pages){
            if(e.getName().equalsIgnoreCase(value)){
                 masteries = e.getMasteries();
                return masteries;
            }
        }
        return null;

    }

    public void initializeImagesView(){

        // Red Page --------------------------------------------

        ImageView m6111 = (ImageView) findViewById(R.id.fury);
        ImageView m6114 = (ImageView) findViewById(R.id.sorcery);
        ImageView m6121 = (ImageView) findViewById(R.id.dobleSword);
        ImageView m6122 = (ImageView) findViewById(R.id.feast);
        ImageView m6131 = (ImageView) findViewById(R.id.vampirism);
        ImageView m6134 = (ImageView) findViewById(R.id.naturalTalent);
        ImageView m6141 = (ImageView) findViewById(R.id.bHunter);
        ImageView m6142 = (ImageView) findViewById(R.id.opresor);
        ImageView m6151 = (ImageView) findViewById(R.id.Bblow);
        ImageView m6154 = (ImageView) findViewById(R.id.Pircing);
        ImageView m6161 = (ImageView) findViewById(R.id.warlord);
        ImageView m6162 = (ImageView) findViewById(R.id.fervor);
        ImageView m6164 = (ImageView) findViewById(R.id.deadTouch);

        // Blue Page --------------------------------------------
        ImageView m6311 = (ImageView) findViewById(R.id.wanderer);
        ImageView m6312 = (ImageView) findViewById(R.id.savagery);
        ImageView m6321 = (ImageView) findViewById(R.id.runic);
        ImageView m6322 = (ImageView) findViewById(R.id.secret);
        ImageView m6323 = (ImageView) findViewById(R.id.assasin);
        ImageView m6331 = (ImageView) findViewById(R.id.merciless);
        ImageView m6332 = (ImageView) findViewById(R.id.meditation);
        ImageView m6342 = (ImageView) findViewById(R.id.bandit);
        ImageView m6343 = (ImageView) findViewById(R.id.dangerous);
        ImageView m6351 = (ImageView) findViewById(R.id.precision);
        ImageView m6352 = (ImageView) findViewById(R.id.intelli);
        ImageView m6361 = (ImageView) findViewById(R.id.storm);
        ImageView m6362 = (ImageView) findViewById(R.id.thunderlord);
        ImageView m6363 = (ImageView) findViewById(R.id.windspeaker);
        mapaMaestrias = new HashMap();

        mapaMaestrias.put(6111,m6111);
        mapaMaestrias.put(6114,m6114);
        mapaMaestrias.put(6121,m6121);
        mapaMaestrias.put(6122,m6122);
        mapaMaestrias.put(6131,m6131);
        mapaMaestrias.put(6134,m6134);
        mapaMaestrias.put(6141,m6141);
        mapaMaestrias.put(6142,m6142);
        mapaMaestrias.put(6151,m6151);
        mapaMaestrias.put(6154,m6154);
        mapaMaestrias.put(6161,m6161);
        mapaMaestrias.put(6162,m6162);
        mapaMaestrias.put(6164,m6164);

        mapaMaestrias.put(6311,m6311);
        mapaMaestrias.put(6312,m6312);
        mapaMaestrias.put(6321,m6321);
        mapaMaestrias.put(6322,m6322);
        mapaMaestrias.put(6323,m6323);
        mapaMaestrias.put(6331,m6331);
        mapaMaestrias.put(6332,m6332);
        mapaMaestrias.put(6342,m6342);
        mapaMaestrias.put(6343,m6343);
        mapaMaestrias.put(6351,m6351);
        mapaMaestrias.put(6352,m6352);
        mapaMaestrias.put(6361,m6361);
        mapaMaestrias.put(6362,m6362);
        mapaMaestrias.put(6363,m6363);





        m6111.setImageResource(R.drawable.m_gray_6111);
        m6114.setImageResource(R.drawable.m_gray_6114);
        m6121.setImageResource(R.drawable.m_gray_6121);
        m6122.setImageResource(R.drawable.m_gray_6122);
        m6131.setImageResource(R.drawable.m_gray_6131);
        m6134.setImageResource(R.drawable.m_gray_6134);
        m6141.setImageResource(R.drawable.m_gray_6141);
        m6142.setImageResource(R.drawable.m_gray_6142);
        m6151.setImageResource(R.drawable.m_gray_6151);
        m6154.setImageResource(R.drawable.m_gray_6154);
        m6161.setImageResource(R.drawable.m_gray_6161);
        m6162.setImageResource(R.drawable.m_gray_6162);
        m6164.setImageResource(R.drawable.m_gray_6164);

    }

    ImageView getMasteryImageView(int number){

        return (ImageView) mapaMaestrias.get(number);

    }
    public void getListName(){
        /**
         * Setting my RiotApi key.
         */

        RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");
        java.util.Map<String, Summoner> summoners = null;


        try {
            switch (reg) {
                case "EUW":
                    summoners = api.getSummonersByName(Region.EUW, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.EUW, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "NA":
                    summoners = api.getSummonersByName(Region.NA, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.NA, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "BR":
                    summoners = api.getSummonersByName(Region.BR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.BR, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "LAN":
                    summoners = api.getSummonersByName(Region.LAN, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.LAN, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "KR":
                    summoners = api.getSummonersByName(Region.KR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.KR, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "LAS":
                    summoners = api.getSummonersByName(Region.LAS, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.LAS, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }

                    break;
                case "OCE":
                    summoners = api.getSummonersByName(Region.OCE, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.OCE, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "PBE":
                    summoners = api.getSummonersByName(Region.PBE, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.OCE, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "RU":
                    summoners = api.getSummonersByName(Region.RU, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.RU, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "TR":
                    summoners = api.getSummonersByName(Region.TR, summonerName);
                    summoner = summoners.get(summonerName);
                    p = api.getMasteryPages(Region.TR, summoner.getId());
                    pages = p.getPages();

                    for(MasteryPage e : pages){
                        listName.add(e.getName());

                    }
                    break;
                case "GLOBAL":
                    summoners = api.getSummonersByName(Region.GLOBAL, summonerName);
                    summoner = summoners.get(summonerName);

                    p = api.getMasteryPages(Region.GLOBAL, summoner.getId());
                    pages = p.getPages();
                    for(MasteryPage e : pages) {
                        listName.add(e.getName());

                    }
                    break;


            }


        }catch (RiotApiException e){

            e.printStackTrace();
        }



    }
}//class