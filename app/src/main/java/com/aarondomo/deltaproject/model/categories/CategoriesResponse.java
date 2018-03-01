package com.aarondomo.deltaproject.model.categories;


import java.util.List;

import com.aarondomo.deltaproject.model.Pagination;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesResponse {

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}