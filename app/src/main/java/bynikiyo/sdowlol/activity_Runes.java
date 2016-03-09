package bynikiyo.sdowlol;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.staticdata.RuneData;
import net.rithms.riot.dto.Static.Image;
import net.rithms.riot.dto.Static.Rune;
import net.rithms.riot.dto.Summoner.RunePage;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.RuneSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class activity_Runes extends AppCompatActivity {
        private ArrayAdapter adapter;
        private ListView list;
        private ArrayList<String> arrayNamePages;
        private Map<Integer,Integer> mapIdRunes = null;
        private RiotApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__runes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        /**
         * Getting data from infoSummoner Activity
         */
        Long summonerId = getIntent().getExtras().getLong("summonerId");
        String reg = getIntent().getExtras().getString("region");
        list = (ListView) findViewById(R.id.listRunes);
        /**
         * Setting toolbar title
         */
        getSupportActionBar().setTitle("Runes Pages");

         api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");
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
            RunePages runespages = api.getRunePages(api.getRegion(),summonerId);
            final Set<RunePage> setRunnes = runespages.getPages();
            arrayNamePages = new ArrayList();

            for(RunePage r : setRunnes){
                arrayNamePages.add(r.getName());

            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayNamePages);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    getSupportActionBar().setTitle(adapter.getItem(position).toString());
                    list.setVisibility(View.GONE);
                    Set<RuneSlot> slotR = null;
                    mapIdRunes = new HashMap<Integer, Integer>();
                    for(RunePage r : setRunnes){
                        if(r.getName().equalsIgnoreCase(adapter.getItem(position).toString())){
                            slotR = r.getSlots();

                        }

                    }

                    for(RuneSlot s: slotR){


                        if(mapIdRunes.get(s.getRuneId()) == null){
                            mapIdRunes.put(s.getRuneId(),1);
                        } else {

                            int count = mapIdRunes.get(s.getRuneId());
                            mapIdRunes.put(s.getRuneId(),count+1);
                        }

                    }
                    for (int i : mapIdRunes.values()){

                        Log.d("INFO", String.valueOf(i));

                    }

                    for (int i : mapIdRunes.keySet())
                    {

                        try {

                                Log.d("HOLIWI",api.getDataRune(i).getName());
                        } catch (RiotApiException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e){
                            e.printStackTrace();

                        }
                    }


                }
            });
        } catch (RiotApiException e) {
            e.printStackTrace();
        }

    }

}
