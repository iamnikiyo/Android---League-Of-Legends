package bynikiyo.sdowlol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Masteries extends AppCompatActivity {
    public float init_x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masteries);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
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

        ImageView fury = (ImageView) findViewById(R.id.fury);
        ImageView sorcery = (ImageView) findViewById(R.id.sorcery);
        ImageView dobleSword = (ImageView) findViewById(R.id.dobleSword);
        ImageView feast = (ImageView) findViewById(R.id.feast);
        ImageView vampirism = (ImageView) findViewById(R.id.vampirism);
        ImageView naturalTalent = (ImageView) findViewById(R.id.naturalTalent);
        ImageView bBlow = (ImageView) findViewById(R.id.Bblow);
        ImageView piercing = (ImageView) findViewById(R.id.Pircing);
        ImageView warlord = (ImageView) findViewById(R.id.warlord);
        ImageView fervor = (ImageView) findViewById(R.id.fervor);
        ImageView deadTouch = (ImageView) findViewById(R.id.deadTouch);




        fury.setImageResource(R.drawable.m_gray_6111);
        sorcery.setImageResource(R.drawable.m_gray_6114);
        dobleSword.setImageResource(R.drawable.m_gray_6121);
        feast.setImageResource(R.drawable.m_gray_6122);
        vampirism.setImageResource(R.drawable.m_gray_6131);
        naturalTalent.setImageResource(R.drawable.m_gray_6134);
        bBlow.setImageResource(R.drawable.m_gray_6151);
        piercing.setImageResource(R.drawable.m_gray_6154);
        warlord.setImageResource(R.drawable.m_gray_6161);
        fervor.setImageResource(R.drawable.m_gray_6162);
        deadTouch.setImageResource(R.drawable.m_gray_6164);

    }
    }


