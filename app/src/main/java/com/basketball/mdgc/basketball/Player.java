package com.basketball.mdgc.basketball;

import android.support.annotation.Nullable;

public class Player {

    int portrait;
    String nick;
    int ELO;

    Player(@Nullable int portrait, String nick, int ELO){
        this.portrait = portrait;
        this.nick = nick;
        this.ELO = ELO;
    }

}
