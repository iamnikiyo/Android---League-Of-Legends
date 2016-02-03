package bynikiyo.sdowlol;

import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bynikiyo on 3/02/16.
 */
public class listData extends ListActivity {

    private ListView lista;
    private ArrayAdapter<String> adaptador;


    public listData() {

    }

    public ListView getLista(ArrayList<String> arrayList){

        adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        setListAdapter(adaptador);

        return lista;
    }
}
