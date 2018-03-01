package com.aarondomo.deltaproject.presenters;


import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.aarondomo.deltaproject.model.categories.CategoriesResponse;
import com.aarondomo.deltaproject.model.categories.Category;
import com.aarondomo.deltaproject.model.events.Event;
import com.aarondomo.deltaproject.model.events.EventsResponse;
import com.aarondomo.deltaproject.remote.LastLocationProvider;
import com.aarondomo.deltaproject.remote.RemoteDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class EventsListActivityPresenter {

    private static final String TAG = EventsListActivityPresenter.class.getName();
    private static final String ERROR_TITLE = "Upps! Something went wrong, error:";
    private static final String PARAMETER_CATEGORIES = "categories";
    private static final String PARAMETER_LATITUDE = "location.latitude";
    private static final String PARAMETER_LONGITUDE = "location.longitude";
    private final String NO_EVENTS_TITLE = "Sorry";
    private final String NO_EVENTS_MESSAGE = "No events near in this category";

    private LastLocationProvider lastLocationProvider;

    public interface View {

        void displayData(List<Category> categories);

        void displayAlert(String title, String message);

        void goToEventsList(List<Event> events);
    }


    private View view;

    private RemoteDataSource remoteDataSource;

    private Context context;

    public EventsListActivityPresenter(RemoteDataSource remoteDataSource, Context context) {
        this.remoteDataSource = remoteDataSource;
        this.context = context;
        lastLocationProvider = new LastLocationProvider(context);
    }


    public void attachView(View view){
        this.view = view;
    }

    public void dettachView(){
        this.view = null;
    }

    public void loadCategories() {
        Observer observer = new Observer<List<Category>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Category> categories) {
                view.displayData(categories);
            }

            @Override
            public void onError(Throwable e) {
                view.displayAlert(ERROR_TITLE,  e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        remoteDataSource.getRemoteService().getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<CategoriesResponse, List<Category>>() {
                    @Override
                    public List<Category> apply(CategoriesResponse results) throws Exception {
                        return results.getCategories();
                    }
                })
                .subscribe(observer);

    }

    public void retrieveEventsInCategory(String categoryId){
        Observer observer = new Observer<List<Event>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Event> events) {
                if (events == null || events.isEmpty()){
                    view.displayAlert(NO_EVENTS_TITLE, NO_EVENTS_MESSAGE);
                } else {
                    view.goToEventsList(events);
                }
            }

            @Override
            public void onError(Throwable e) {
                view.displayAlert(ERROR_TITLE,  e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        Location location = lastLocationProvider.getLocation();

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(PARAMETER_CATEGORIES, categoryId);

        if(location != null){
            queryMap.put(PARAMETER_LATITUDE, Double.toString(location.getLatitude()));
            queryMap.put(PARAMETER_LONGITUDE, Double.toString(location.getLongitude()));
        }

        remoteDataSource.getRemoteService().getEvents(queryMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<EventsResponse, List<Event>>() {
                    @Override
                    public List<Event> apply(EventsResponse eventsResponse) throws Exception {
                        return eventsResponse.getEvents();
                    }
                })
                .subscribe(observer);
    }



}
