package com.aarondomo.deltaproject.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aarondomo.deltaproject.R;
import com.aarondomo.deltaproject.model.events.Event;

import java.util.List;

public class EventbriteEventAdapter extends RecyclerView.Adapter<EventbriteEventAdapter.EventbriteEventViewHolder> {

    private List<Event> eventList;

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public EventbriteEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.eventbrite_event_card, parent, false);
        return new EventbriteEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventbriteEventViewHolder holder, int position) {
        Event event = eventList.get(position);

        holder.name.setText(event.getName().getText());
        holder.description.setText(event.getDescription().getText());

    }

    @Override
    public int getItemCount() {
        return eventList != null? eventList.size() : 0;
    }

    public class EventbriteEventViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView description;

        public EventbriteEventViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textview_eventcard_name);
            description = itemView.findViewById(R.id.textview_eventcard_description);

        }
    }
}
