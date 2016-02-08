package bynikiyo.sdowlol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.Summoner;

public class masteries_list extends AppCompatActivity {
        private ListView listaAndroid;
        private Summoner summoner;
        private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masteries_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Objeto para recibir los datos del summoner desde infoSummoner
         */
        summoner = (Summoner) getIntent().getSerializableExtra("Summoner");

        MasteryPages paginas = new MasteryPages();

    }

}
