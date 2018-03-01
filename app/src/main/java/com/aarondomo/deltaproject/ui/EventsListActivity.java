package com.aarondomo.deltaproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.aarondomo.deltaproject.R;
import com.aarondomo.deltaproject.model.events.Event;
import com.aarondomo.deltaproject.ui.adapters.EventbriteEventAdapter;

import org.parceler.Parcels;

import java.util.List;

import static com.aarondomo.deltaproject.utils.StringKeys.EVENT_LIST_KEY;

public class EventsListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        recyclerViewEventList = (RecyclerView) findViewById(R.id.recyclerview_main_displayevents);

        List<Event> events = Parcels.unwrap(getIntent().getParcelableExtra(EVENT_LIST_KEY));

        EventbriteEventAdapter eventbriteEventAdapter = new EventbriteEventAdapter();
        eventbriteEventAdapter.setEventList(events);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewEventList.setLayoutManager(linearLayoutManager);

        recyclerViewEventList.setAdapter(eventbriteEventAdapter);


    }
}
