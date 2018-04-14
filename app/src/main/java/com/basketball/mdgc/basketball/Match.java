package com.basketball.mdgc.basketball;

import java.util.ArrayList;

public class Match {
    ArrayList<String> players;

    int localizationID;
    int playersLimit;
    String status;

    public Match(){

    }

    public Match(ArrayList<String> players, int localizationID, int playersLimit, String status){
        this.players = players;
        this.localizationID = localizationID;
        this.playersLimit = playersLimit;
        this.status = status;
    }
}
