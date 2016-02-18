package bynikiyo.sdowlol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;

public class freeToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_to_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("FREE ROTATION");

        RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");

        try {
            ChampionList freeList = api.getFreeToPlayChampions();

            for(Champion ch : freeList.getChampions()){
                Long id = ch.getId();

            }
        } catch (RiotApiException e) {
            e.printStackTrace();
        }



    }

}
