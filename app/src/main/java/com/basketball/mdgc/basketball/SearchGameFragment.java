package com.basketball.mdgc.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchGameFragment extends Fragment {

    View view;
    RelativeLayout linearLayout;
    DatabaseReference mDatabase;

    GamesListAdapter gamesListAdapter;

    private ArrayList<Match> lista;

    ChildEventListener postListener = new ChildEventListener() {

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            List<Match> list = new ArrayList<>();
            for(DataSnapshot ds: dataSnapshot.getChildren()){
                list.add(ds.getValue(Match.class));
            }
            lista = new ArrayList<>();
            lista.addAll(list);

            gamesListAdapter.setData(lista);

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {


        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }


    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_game_layout, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        ListView listView = view.findViewById(R.id.search_game_list_view);

        lista = new ArrayList<>();
        gamesListAdapter = new GamesListAdapter(getContext(), new ArrayList<Match>());

        listView.setAdapter(gamesListAdapter);

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
            public void onClick(View view2) {
                EditText localizationIDTextView = view.findViewById(R.id.search_game_edit_text_localization);;
                EditText playersLimitTextView = view.findViewById(R.id.search_game_edit_text_players_limit);;
                EditText statusIDTextView = view.findViewById(R.id.search_game_edit_text_status);;

                int localizationID = Integer.parseInt(localizationIDTextView.getText().toString());
                int playersLimit = Integer.parseInt(playersLimitTextView.getText().toString());
                String status = statusIDTextView.getText().toString();

                Match mecz = new Match(new ArrayList<String>(),localizationID,playersLimit,status);
                mDatabase.child("events").child("events2").child(mDatabase.child("events").push().getKey()).setValue(mecz);

                mDatabase.child("events").addChildEventListener(postListener);

                linearLayout.setVisibility(View.GONE);
                gamesListAdapter.notifyDataSetChanged();
            }
        });


        //DATA

        mDatabase.child("events").addChildEventListener(postListener);
        //DATA

        return view;
    }


}
