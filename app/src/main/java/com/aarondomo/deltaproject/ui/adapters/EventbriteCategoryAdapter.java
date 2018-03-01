package com.aarondomo.deltaproject.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aarondomo.deltaproject.R;
import com.aarondomo.deltaproject.model.categories.Category;
import com.aarondomo.deltaproject.ui.listeners.OnItemClickedListener;

import java.util.List;

public class EventbriteCategoryAdapter extends RecyclerView.Adapter<EventbriteCategoryAdapter.EventbriteCategoryViewHolder> {

    private List<Category> eventCategoryList;

    private Context context;

    private OnItemClickedListener onItemClickedListener;

    public EventbriteCategoryAdapter(Context context) {
        onItemClickedListener = (OnItemClickedListener) context;
    }

    public void setEventCategoryList(List<Category> eventCategoryList){
        this.eventCategoryList = eventCategoryList;
    }

    @Override
    public EventbriteCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new EventbriteCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventbriteCategoryViewHolder holder, int position) {
        Category category  = eventCategoryList.get(position);

        holder.textViewFlight.setText(category.getName());

        switch (position % 2){
            case 0:
                holder.relativeLayout.setBackgroundColor(Color.rgb(198, 225, 255));
                break;
            case 1:
                holder.relativeLayout.setBackgroundColor(Color.rgb(240, 239, 255));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return eventCategoryList != null? eventCategoryList.size() : 0;
    }

    public class EventbriteCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relativeLayout;
        TextView textViewFlight;

        public EventbriteCategoryViewHolder(View itemView) {
            super(itemView);

            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativelayout_item_category);
            textViewFlight =  (TextView) itemView.findViewById(R.id.textview_item_categoryname);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onItemClickedListener.onItemClicked(eventCategoryList.get(getLayoutPosition()));
        }
    }
}
