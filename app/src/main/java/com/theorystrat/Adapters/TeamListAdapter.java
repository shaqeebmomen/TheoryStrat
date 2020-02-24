package com.theorystrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.DataModels.Team;
import com.theorystrat.R;
import com.theorystrat.ViewHolders.TeamItemHolder;

import java.util.ArrayList;


public class TeamListAdapter extends RecyclerView.Adapter<TeamItemHolder> {


    private ArrayList<Team> teams = new ArrayList<>();
    private OnTeamListener onTeamListener;


    // Constructor to pass the implementation into
    public TeamListAdapter(OnTeamListener onTeamListener) {
        this.onTeamListener = onTeamListener;
        setHasStableIds(true);

    }

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
        holder.setTeamNum(teams.get(position).getTeamNum());
        //TODO add the field for city and team name in the teams data model then bind here
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public interface OnTeamListener {
        void onTeamClick(int pos, View v);
    }


    public void setTeams(ArrayList<Team> teams) {
        this.teams.clear();
        this.teams.addAll(teams);
    }
}
