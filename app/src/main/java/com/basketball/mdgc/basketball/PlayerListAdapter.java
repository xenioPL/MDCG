package com.basketball.mdgc.basketball;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerListAdapter extends BaseAdapter {

    ArrayList<Player> players;
    Context context;

    PlayerListAdapter(Context context, ArrayList<Player> players){
        this.players = players;
        this.context = context;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Player getItem(int i) {
        if(i > 0 && i < getCount())
            return players.get(i);
        else
            return players.get(0);
    }

    @Override
    public long getItemId(int i) {
        if(i > 0 && i < getCount())
            return i;
        else
            return 0;
    }

    static class ViewHolder{
        TextView nick;
        ImageView portrait;
        TextView ELO;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final View view;
        final ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.player_element, null, false);
            viewHolder.nick = view.findViewById(R.id.player_element_name);
            viewHolder.portrait = view.findViewById(R.id.player_element_portrait);
            viewHolder.ELO = view.findViewById(R.id.player_element_elo);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

       Player player = players.get(position);

        viewHolder.nick.setText(String.valueOf(player.nick));
        viewHolder.portrait.setImageResource(player.portrait);
        viewHolder.ELO.setText(String.valueOf(player.ELO));
        return view;
    }

    public void setData(ArrayList<Player> players){
        this.players = players;
        this.notifyDataSetChanged();
    }
}
