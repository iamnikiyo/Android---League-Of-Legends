package bynikiyo.sdowlol;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;
import net.rithms.riot.dto.Static.Image;

public class freeToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_to_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getSupportActionBar().setTitle("FREE ROTATION");
        ImageView foto = (ImageView) findViewById(R.id.imageView);
        String nombreImg = "kalista";
        int res_imagen = freeToPlay.this.getResources().getIdentifier("drawable/" + nombreImg, null, freeToPlay.this.getPackageName());
        foto.setImageResource(res_imagen);
        ImageView foto2 = (ImageView) findViewById(R.id.imageView2);

        /*RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");

        try {
            ChampionList freeList = api.getFreeToPlayChampions();

            for (Champion ch : freeList.getChampions()){

                //Image img = api.getDataChampion((int)ch.getId()).getImage();

                String nombreImg = api.getDataChampion((int)ch.getId()).getName().toLowerCase() +".png";

                int res_imagen = freeToPlay.this.getResources().getIdentifier("drawable/" + nombreImg, null, freeToPlay.this.getPackageName());
                foto.setImageResource(res_imagen);
            }

        } catch (RiotApiException e) {
            e.printStackTrace();
        } catch(NullPointerException a){
            a.printStackTrace();
        }

*/

    }

}
