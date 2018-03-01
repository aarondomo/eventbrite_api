
package com.aarondomo.deltaproject.model.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Description {

    @SerializedName("text")
    @Expose
     String text;
    @SerializedName("html")
    @Expose
     String html;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

}
