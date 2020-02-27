package com.theorystrat.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.theorystrat.Fragments.MatchesFragment;
import com.theorystrat.Fragments.TeamSummaryFragment;
import com.theorystrat.ViewModels.MatchesViewModel;

public class TeamDisplayAdapter extends FragmentStateAdapter {

    private MatchesViewModel matchesViewModel;
    private String selectedTeam;

    public TeamDisplayAdapter(@NonNull Fragment fragment, MatchesViewModel matchesViewModel) {
        super(fragment);
        this.matchesViewModel = matchesViewModel;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // First Tab will be the team summary
        if (position == 0) {
            return new TeamSummaryFragment();
        }
        // The second screen will be the team's matches
        else if (position == 1) {
            return new MatchesFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
