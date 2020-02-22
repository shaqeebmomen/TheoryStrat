package com.theorystrat.ViewHolders;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theorystrat.Adapters.TournyListAdapter;
import com.theorystrat.R;


public class TournyItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView textView;
    private TournyListAdapter.OnTournyListener onTournyListener;
    private View container;
    private boolean selected = false;

    public TournyItemHolder(@NonNull View itemView, TournyListAdapter.OnTournyListener onTournyListener) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.tourny_item_text);
        this.onTournyListener = onTournyListener;
        this.container = itemView.findViewById(R.id.tourny_item_container);
        itemView.setOnClickListener(this);
    }


    public TextView getTextView() {
        return textView;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            container.setBackgroundColor(Color.CYAN);
        } else {
            container.setBackgroundColor(Color.WHITE);
        }
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void onClick(View v) {
        onTournyListener.onTournyClick(getAdapterPosition(), v);
    }
}
