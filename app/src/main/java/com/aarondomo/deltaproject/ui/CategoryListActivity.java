package com.aarondomo.deltaproject.ui;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarondomo.deltaproject.R;
import com.aarondomo.deltaproject.di.DaggerMainComponent;
import com.aarondomo.deltaproject.di.MainModule;
import com.aarondomo.deltaproject.model.categories.Category;
import com.aarondomo.deltaproject.model.events.Event;
import com.aarondomo.deltaproject.presenters.EventsListActivityPresenter;
import com.aarondomo.deltaproject.ui.adapters.EventbriteCategoryAdapter;
import com.aarondomo.deltaproject.ui.listeners.OnItemClickedListener;


import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import static com.aarondomo.deltaproject.utils.StringKeys.EVENT_LIST_KEY;

public class CategoryListActivity extends AppCompatActivity implements EventsListActivityPresenter.View, OnItemClickedListener {

    private static final String TAG = CategoryListActivity.class.getName();
    private static final String OK_STRING = "Ok";

    @Inject
    EventsListActivityPresenter presenter;

    private RecyclerView recyclerView;

    private EventbriteCategoryAdapter eventbriteCategoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpDaggerComponent();

        presenter.attachView(this);

        setUpRecyclerView();

        presenter.loadCategories();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }


    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_displaycategories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        eventbriteCategoryAdapter = new EventbriteCategoryAdapter(this);

        recyclerView.setAdapter(eventbriteCategoryAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void setUpDaggerComponent() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void displayData(List<Category> categories) {
        eventbriteCategoryAdapter.setEventCategoryList(categories);
        eventbriteCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void displayAlert(String title, String message) {
        createAlertDialog(title, message);
    }

    @Override
    public void goToEventsList(List<Event> events) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENT_LIST_KEY, Parcels.wrap(events));

        Intent intent = new Intent(CategoryListActivity.this, EventsListActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onItemClicked(Category category) {
        presenter.retrieveEventsInCategory(category.getId());
    }

    private void createAlertDialog(String title, String message){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setNeutralButton(OK_STRING, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
