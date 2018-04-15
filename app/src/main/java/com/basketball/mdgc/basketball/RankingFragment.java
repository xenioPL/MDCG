package com.basketball.mdgc.basketball;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class RankingFragment extends Fragment{

        View view;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.ranking_layout, container, false);

            Spinner spinner = view.findViewById(R.id.ranking_types_spinner);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.ranking_types_array, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);
            ArrayList<Player> data = new ArrayList<>();
            data.add(new Player(null, "Jasiek", 450));
            data.add(new Player(null, "Ania", 421));
            data.add(new Player(null, "Robert", 392));
            ListView list = view.findViewById(R.id.ranking_list);
            RankingListAdapter rankingListAdapter = new RankingListAdapter(getContext(), data);
            list.setAdapter(rankingListAdapter);
            return view;
        }
}
