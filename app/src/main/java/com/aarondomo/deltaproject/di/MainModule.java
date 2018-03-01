package com.aarondomo.deltaproject.di;

import android.content.Context;

import com.aarondomo.deltaproject.presenters.EventsListActivityPresenter;
import com.aarondomo.deltaproject.remote.RemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final Context context;

    public MainModule(Context context) {
        this.context = context;
    }


    @Provides
    public EventsListActivityPresenter providesMainActivityPresenter(){
        return new EventsListActivityPresenter(new RemoteDataSource(), context);
    }

}
