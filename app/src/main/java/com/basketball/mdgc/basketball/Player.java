package com.basketball.mdgc.basketball;

import android.support.annotation.Nullable;

public class Player {

    Integer portrait;
    String nick;
    int ELO;

    Player(@Nullable Integer portrait, String nick, int ELO){
        this.portrait = portrait;
        this.nick = nick;
        this.ELO = ELO;
    }

}
