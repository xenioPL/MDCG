package com.basketball.mdgc.basketball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GamesListAdapter extends BaseAdapter {

    ArrayList<Match> matches;
    Context context;

    GamesListAdapter(Context context, ArrayList<Match> matches){
        this.matches = matches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return matches.size();
    }

    @Override
    public Match getItem(int i) {
        if(i > 0 && i < getCount())
            return matches.get(i);
        else
            return matches.get(0);
    }

    @Override
    public long getItemId(int i) {
        if(i > 0 && i < getCount())
            return i;
        else
            return 0;
    }

    static class ViewHolder{
        TextView approxLocalization;
        Button map;
        TextView status;
        TextView playersNumber;
        Button detailsArrow;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.game_element, null, false);
            viewHolder.approxLocalization = view.findViewById(R.id.games_list_element_approx_localization_text);
            viewHolder.map = view.findViewById(R.id.games_list_element_map_button);
            viewHolder.status = view.findViewById(R.id.games_list_element_status_text);
            viewHolder.playersNumber = view.findViewById(R.id.games_list_element_players_numbers_text);
            viewHolder.detailsArrow = view.findViewById(R.id.games_list_element_details_arrow_button);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        Match match = matches.get(position);

        viewHolder.approxLocalization.setText(String.valueOf(match.localizationID));
        viewHolder.status.setText(match.status);
        viewHolder.playersNumber.setText(String.valueOf(match.playersLimit));
        return view;
    }

    public void setData(ArrayList<Match> matches){
        this.matches = matches;
        notifyDataSetChanged();
    }
}
