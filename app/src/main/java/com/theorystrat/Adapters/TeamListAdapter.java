package com.theorystrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.theorystrat.DataModels.Team;
import com.theorystrat.R;
import com.theorystrat.ViewHolders.TeamItemHolder;

// Using List Adapter to provide animations and load items more efficiently
public class TeamListAdapter extends ListAdapter<Team, TeamItemHolder> {
    private static final String TAG = "TeamListAdapter";

    private OnTeamListener onTeamListener;



    public TeamListAdapter(OnTeamListener onTeamListener) {
        super(DIFF_CALLBACK);
        this.onTeamListener = onTeamListener;
    }

    // Defining the methods to check differences locally
    private static final DiffUtil.ItemCallback<Team> DIFF_CALLBACK = new DiffUtil.ItemCallback<Team>() {

        // Make this method return true when the compared items refer to the same team
        @Override
        public boolean areItemsTheSame(@NonNull Team oldItem, @NonNull Team newItem) {
            return oldItem.getTeamNum() == newItem.getTeamNum();
        }


        // Make this method return true when the compared items have the same internal data
        @Override
        public boolean areContentsTheSame(@NonNull Team oldItem, @NonNull Team newItem) {
            return oldItem.equals(newItem);
        }
    };


    @NonNull
    @Override
    public TeamItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_list_item, parent, false);
        return new TeamItemHolder(itemView, onTeamListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamItemHolder holder, int position) {
        // Bind data to each view
        // getItem() is a method of the superclass that will return the list we passed into this
        holder.setTeamNum(getItem(position).getTeamNum());
        holder.setDataCount(Integer.toString(getItem(position).getDataCount()));
        //TODO add the field for city and team name in the teams data model then bind here
    }


    public interface OnTeamListener {
        public void onClick(int pos, View v);
    }

}
