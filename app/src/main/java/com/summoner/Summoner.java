package com.summoner;

import android.util.Log;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.connection.Connection;
import com.global.Global;


public class Summoner {
		// Variables
	private Long id,revisionDate,summonerLevel;
	private String name;
	private int profileIconId;
	private JSONArray masteries;
	private String server;
    static String version = "v1.4";  
	
		// Metodos de la clase
	
		
		public Summoner(String name,String server) throws IOException {

			recogeSummoner(name.toLowerCase().replace(" ",""),server);
			
	
		}
		
		private void recogeSummoner(String name,String server)throws IOException{
			 	
				
		        String version = "v1.4";   
		        
		        String url ="https://"+server+".api.pvp.net/api/lol/"+server+"/"+version+"/summoner/by-name/"+name+"?api_key="+Global.key;
		        try {
					JSONObject json = Connection.readJsonFromUrl(url);

		        this.id = json.getJSONObject(name).getLong("id");
		        this.revisionDate = json.getJSONObject(name).getLong("revisionDate");
		        this.summonerLevel = json.getJSONObject(name).getLong("summonerLevel");
		        this.name = json.getJSONObject(name).getString("name");
		        this.profileIconId = json.getJSONObject(name).getInt("profileIconId");
		        this.server = server;
		        this.masteries = Masteries.recogeMasteries(name,id,server);
				}catch(JSONException e){
					Log.d("ERROR","JSON");
				}
		}

		public Long getId() {
			return id;
		}

		public Long getRevisionDate() {
			return revisionDate;
		}

		public Long getSummonerLevel() {
			return summonerLevel;
		}

		public String getName() {
			return name;
		}

		public int getProfileIconId() {
			return profileIconId;
		}

		
		public JSONArray getMasteries() {
			return masteries;
		}

		@Override
		public String toString() {
			return "Summoner [id=" + id + ", revisionDate=" + revisionDate + ", summonerLevel=" + summonerLevel
					+ ", name=" + name + ", profileIconId=" + profileIconId + "]";
		}
		
		
		
		
	
		
	
	
	
	
	
}
