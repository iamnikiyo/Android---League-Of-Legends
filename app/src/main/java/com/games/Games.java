package com.games;

import android.util.Log;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.connection.Connection;
import com.global.*;
import com.summoner.*;
import org.json.JSONException;

public class Games {
	// variables
	private int wins,losses,totalChampionKills,totalAssists,maxChampionsKilled,averageNodeCapture,averageNodeNeutralize,averageTeamObjective,averageTotalPlayerScore,averageCombatPlayerScore,averageObjectivePlayerScore,averageNodeCaptureAssist,averageNodeNeutralizeAssist,maxNodeCapture,maxNodeNeutralize,maxTeamObjective,maxTotalPlayerScore,maxCombatPlayerScore,maxObjectivePlayerScore,maxNodeCaptureAssist,maxNodeNeutralizeAssist,totalNodeNeutralize,totalNodeCapture,averageChampionsKilled,averageNumDeaths,averageAssists,maxAssists;
	private Long modifyDate;
	private String playerStatSummaryType;
	private String version = "v1.3";
	private JSONObject json;
	
	
	public Games(String name, String opcion,String server)throws IOException{
		recogeDatos(calculaTipo(opcion,name,server));
		
	}
	private void recogeDatos(int numero) throws IOException { 
		try{
		this.wins = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getInt("wins");
		this.playerStatSummaryType = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getString("playerStatSummaryType");
		this.modifyDate = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getLong("modifyDate");
		try{
			this.losses = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getInt("losses");
		}catch(JSONException e) {
			this.losses = -1;
		}
		try {
		this.averageAssists = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageAssists");
		this.averageChampionsKilled = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageChampionsKilled");
		this.averageCombatPlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageCombatPlayerScore");
		this.averageNodeCapture = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageNodeCapture");
		this.averageNodeCaptureAssist = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageNodeCaptureAssist");
		this.averageNodeNeutralize = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageNodeNeutralize");
		this.averageNodeNeutralizeAssist = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageNodeNeutralizeAssist");
		this.averageNumDeaths = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageNumDeaths");
		this.averageObjectivePlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageObjectivePlayerScore");
		this.averageTeamObjective = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageTeamObjective");
		this.averageTotalPlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("averageTotalPlayerScore");
		this.maxAssists = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxAssists");
		this.maxChampionsKilled = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxChampionsKilled");
		this.maxCombatPlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxCombatPlayerScore");
		this.maxNodeCapture = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxNodeCapture");
		this.maxNodeCaptureAssist = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxNodeCaptureAssist");
		this.maxNodeNeutralize = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxNodeNeutralize");
		this.maxNodeNeutralizeAssist = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxNodeNeutralizeAssist");
		this.maxObjectivePlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxObjectivePlayerScore");
		this.maxTeamObjective = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxTeamObjective");
		this.maxTotalPlayerScore = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("maxTotalPlayerScore");
		this.totalAssists = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("totalAssists");
		this.totalChampionKills = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("totalChampionKills");
		this.totalNodeCapture = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("totalNodeCapture ");
		this.totalNodeNeutralize = json.getJSONArray("playerStatSummaries").getJSONObject(numero).getJSONObject("aggregatedStats").getInt("totalNodeNeutralize");
		
		}catch(JSONException a){
			System.out.println(a.getMessage());
		}
		}catch(JSONException e) {
			Log.d("ERROR","JSON");}
	}

	
	private int calculaTipo(String opcion,String name,String server)throws IOException{
		Summoner summoner = new Summoner(name,server);
		String url ="https://euw.api.pvp.net/api/lol/euw/"+version+"/stats/by-summoner/"+summoner.getId()+"/summary?season=SEASON2015&api_key="+Global.key;
		try{
		this.json = Connection.readJsonFromUrl(url);
		JSONArray array = json.getJSONArray("playerStatSummaries");	
		
		for(int i =0 ;i<array.length();i++){
			String type = json.getJSONArray("playerStatSummaries").getJSONObject(i).getString("playerStatSummaryType");
			if(type.equals(opcion)){
				return i;
			}
		} 

		}catch(JSONException e) {
			Log.d("ERROR","JSON");}
		return -1;
	}
	public int getWins() {
		return wins;
	}
	@Override
	public String toString() {
		return "Games [wins=" + wins + ", losses=" + losses + ", modifyDate=" + modifyDate + ", playerStatSummaryType="
				+ playerStatSummaryType + ", version=" + version + "]";
	}
	
	
	
	
	
}