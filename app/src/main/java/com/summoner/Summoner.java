package com.summoner;

import com.connection.Connection;
import com.global.Global;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Summoner {
		// Variables
	public Long id,revisionDate,summonerLevel;
	public String name;
	public int profileIconId;
	
		// Metodos de la clase
	
		
		public Summoner(String name) throws IOException,JSONException {

			recogeSummoner(name.toLowerCase().replace(" ",""));
			
	
		}
		
		private void recogeSummoner(String name)throws IOException,JSONException{
			 	
				String server = "euw";
		        String version = "v1.4";   
		        
		        String url ="https://"+server+".api.pvp.net/api/lol/"+server+"/"+version+"/summoner/by-name/"+name+"?api_key="+Global.key;
		        JSONObject json = Connection.readJsonFromUrl(url);
		        this.id = json.getJSONObject(name).getLong("id");
		        this.revisionDate = json.getJSONObject(name).getLong("revisionDate");
		        this.summonerLevel = json.getJSONObject(name).getLong("summonerLevel");
		        this.name = json.getJSONObject(name).getString("name");
		        this.profileIconId = json.getJSONObject(name).getInt("profileIconId");
		
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

		@Override
		public String toString() {
			return "Summoner [id=" + id + ", revisionDate=" + revisionDate + ", summonerLevel=" + summonerLevel
					+ ", name=" + name + ", profileIconId=" + profileIconId + "]";
		}
		
		
		
	
		
	
	
	
	
	
}
