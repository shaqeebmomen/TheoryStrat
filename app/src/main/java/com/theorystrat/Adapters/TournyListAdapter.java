package com.theorystrat.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.R;
import com.theorystrat.ViewHolders.TournyItemHolder;

import java.util.ArrayList;


public class TournyListAdapter extends RecyclerView.Adapter<TournyItemHolder> {

    private ArrayList<String> events = new ArrayList<>();
    private OnTournyListener onTournyListener;
    private int selectedPos = -1;


    public TournyListAdapter(OnTournyListener onTournyListener) {
        this.onTournyListener = onTournyListener;

    }


    // Called to make each holder
    @NonNull
    @Override
    public TournyItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tourny_list_item, parent, false);
        return new TournyItemHolder(itemView, onTournyListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TournyItemHolder holder, int position) {
        String eventName = events.get(position);
        holder.getTextView().setText(eventName);

        // Check if the item is to be highlighted
        holder.setSelected(position == selectedPos);

    }


    @Override
    public int getItemCount() {
        return events.size();
    }


    public interface OnTournyListener {
        void onTournyClick(int pos, View v);
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public void setSelectedPos(int selectedPos) {
        this.selectedPos = selectedPos;
    }
}
