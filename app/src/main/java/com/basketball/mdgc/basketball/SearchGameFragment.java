package com.basketball.mdgc.basketball;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchGameFragment extends Fragment {

    View view;
    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_game_layout, container, false);

        Button createGameButton = view.findViewById(R.id.search_game_make_game_button);
        linearLayout = view.findViewById(R.id.make_game_view);

        createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearLayout.getVisibility() == View.GONE)
                    linearLayout.setVisibility(View.VISIBLE);
                else if(linearLayout.getVisibility() == View.VISIBLE)
                    linearLayout.setVisibility(View.GONE);
            }
        });

        Button submitCreateGameButton = view.findViewById(R.id.search_game_create_game);
        submitCreateGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //wyslij mnie na serwer
            }
        });


        //DATA
        //laduj z serwera
        ArrayList<Match> matches = new ArrayList<>();
        matches.add(new Match(new ArrayList<String>(), 21, 43, "kyss"));
        //DATA

        ListView gamesList = view.findViewById(R.id.search_game_list_view);
        GamesListAdapter gamesListAdapter = new GamesListAdapter(getContext(), matches);

        gamesList.setAdapter(gamesListAdapter);

        return view;
    }


}
