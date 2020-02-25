package com.theorystrat.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.Adapters.TeamListAdapter;
import com.theorystrat.R;

public class TeamItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView teamNum;
    private TextView teamCity;
    private TextView teamName;

    private Button seeDetailsBtn;
    private TeamListAdapter.OnTeamListener onTeamListener;


    public TeamItemHolder(@NonNull View itemView, TeamListAdapter.OnTeamListener onTeamListener) {
        super(itemView);
        this.onTeamListener = onTeamListener;
        this.teamNum = itemView.findViewById(R.id.team_list_item_num);
        this.teamCity = itemView.findViewById(R.id.team_list_item_city);
        this.teamName = itemView.findViewById(R.id.team_list_item_name);

        this.seeDetailsBtn = itemView.findViewById(R.id.team_list_details_btn);
        seeDetailsBtn.setOnClickListener(this);

    }



    public void setTeamNum(String num) {
        teamNum.setText(num);
    }

    public void setTeamCity(String city) {
        teamCity.setText(city);
    }

    public void setTeamName(String name) {
        teamName.setText(name);
    }

    public void setDataCount(String s) {
        this.seeDetailsBtn.setText(s);
    }

    @Override
    public void onClick(View v) {
        onTeamListener.onClick();
    }
}
