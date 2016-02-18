package bynikiyo.sdowlol;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button infoSummoner = (Button) findViewById(R.id.buttonSummoner);
        Button about = (Button) findViewById(R.id.aboutButton);
        Button champions = (Button) findViewById(R.id.infoChampion);

        infoSummoner.setOnClickListener(this);
        about.setOnClickListener(this);
        champions.setOnClickListener(this);
    }
    public void onClick(View v) {
        //Define la actividad
        if(v.getId() == R.id.buttonSummoner) {
             i = new Intent(this, infoSummoner.class);
        }else if(v.getId() == R.id.aboutButton){
            i = new Intent(this, about.class);
        }else if (v.getId() == R.id.infoChampion){
            i = new Intent(this,championInfo.class);

        }
        try {
            startActivity(i);
        }catch(NullPointerException ex){

            Log.d("Intent NullPointer", "Intent = null");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
