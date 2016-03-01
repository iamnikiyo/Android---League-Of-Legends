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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;


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


        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);


        RiotApi api = new RiotApi("64a3b34b-e65d-4867-adb6-47e33cf2dfc3");

        try {
            ChampionList freeList = api.getFreeToPlayChampions();

            for (Champion ch : freeList.getChampions()){



                String nombreImg = api.getDataChampion((int)ch.getId()).getName().toLowerCase() + "_0";

                int res_imagen = freeToPlay.this.getResources().getIdentifier("drawable/" + nombreImg.replace(" ",""), null, freeToPlay.this.getPackageName());

                DefaultSliderView slider = new DefaultSliderView(this);

                slider.image(res_imagen);
                sliderShow.addSlider(slider);
            }

        } catch (RiotApiException e) {
            e.printStackTrace();
        } catch(NullPointerException a){
            a.printStackTrace();
        }



    }

}
