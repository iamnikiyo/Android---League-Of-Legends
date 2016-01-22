package com.summoner;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.connection.Connection;
import com.global.Global;

public class Masteries {

	public static JSONArray recogeMasteries(String name,Long id,String server) throws IOException, JSONException {
		
		
		String pageName;
		
		
		String url ="https://"+server+".api.pvp.net/api/lol/"+server+"/"+Summoner.version+"/summoner/"+id+"/masteries?api_key="+Global.key;
		
		
		JSONObject json = Connection.readJsonFromUrl(url);
		
		JSONArray pages = json.getJSONObject(id.toString()).getJSONArray("pages");
		return pages;	
	}
	
	public static ArrayList<JSONArray> getMasteriesArray(JSONArray pages)throws JSONException{
		ArrayList<JSONArray> listaMaestrias = new ArrayList();
		
			for(int i=0;i<pages.length();i++){
				listaMaestrias.add(pages.getJSONObject(i).getJSONArray("masteries"));
				
			}
		return listaMaestrias;
}
		
	
}//class
	
