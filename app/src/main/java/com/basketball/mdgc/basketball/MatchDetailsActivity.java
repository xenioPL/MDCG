package com.basketball.mdgc.basketball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MatchDetailsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);

        Intent intent = getIntent();
        String matchID = intent.getStringExtra("match");
        String localizationText = intent.getStringExtra("localization");
        String statusText = intent.getStringExtra("status");

        ArrayList<Player> players = new ArrayList<>();

        PlayerListAdapter playerListAdapter = new PlayerListAdapter(getApplicationContext(), players);

        ListView playersList = findViewById(R.id.game_details_element_list_view);
        playersList.setAdapter(playerListAdapter);

        TextView status = findViewById(R.id.details_activity_status_text);
        TextView localization = findViewById(R.id.details_activity_localization_text);

        status.setText(statusText);
        localization.setText(localizationText);

        Button leftButton = findViewById(R.id.game_details_element_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
