package com.basketball.mdgc.basketball;

import java.util.ArrayList;

public class Match {
    public ArrayList<String> players;

    public String localizationID;
    public int playersLimit;
    public String ID;
    public String status;

    public Match(){

    }

    public Match(ArrayList<String> players, String localizationID, int playersLimit, String status, String Id){
        this.players = players;
        this.localizationID = localizationID;
        this.playersLimit = playersLimit;
        this.status = status;
        this.ID = Id;
    }
}
