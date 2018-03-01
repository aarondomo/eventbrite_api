package com.aarondomo.deltaproject.di;

import com.aarondomo.deltaproject.ui.CategoryListActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(CategoryListActivity categoryListActivity);

}
