package com.aarondomo.deltaproject.remote;


import com.aarondomo.deltaproject.model.categories.CategoriesResponse;
import com.aarondomo.deltaproject.model.events.EventsResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface EventbriteService {

    @Headers("Authorization: Bearer OLF7IJAHT5MH6OCVKHFN") //anonymous access token
    @GET("categories")
    Observable<CategoriesResponse> getCategories();


    @Headers("Authorization: Bearer OLF7IJAHT5MH6OCVKHFN")
    @GET("events/search")
    Observable<EventsResponse> getEvents(@QueryMap Map<String, String> options);
}
