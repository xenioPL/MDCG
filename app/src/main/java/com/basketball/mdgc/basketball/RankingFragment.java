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

            Spinner spinner = (Spinner) view.findViewById(R.id.ranking_types_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                    R.array.ranking_types_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            ArrayList<String> data = new ArrayList<>();
            data.add("audi");
            data.add("mercedes");
            data.add("lambodzini");
            data.add("audi");
            data.add("mercedes");
            data.add("lambodzini");
            ListView list = view.findViewById(R.id.ranking_list);
            ArrayAdapter<String> aa = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,data);

            list.setAdapter(aa);
            return view;
        }
}
