
package com.aarondomo.deltaproject.model.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Event {

    @SerializedName("name")
    @Expose
     Name name;
    @SerializedName("description")
    @Expose
     Description description;
    @SerializedName("id")
    @Expose
     String id;
    @SerializedName("url")
    @Expose
     String url;
    @SerializedName("vanity_url")
    @Expose
     String vanityUrl;
    @SerializedName("start")
    @Expose
     Start start;
    @SerializedName("end")
    @Expose
     End end;
    @SerializedName("organization_id")
    @Expose
     String organizationId;
    @SerializedName("created")
    @Expose
     String created;
    @SerializedName("changed")
    @Expose
     String changed;
    @SerializedName("capacity")
    @Expose
     Integer capacity;
    @SerializedName("capacity_is_custom")
    @Expose
     Boolean capacityIsCustom;
    @SerializedName("status")
    @Expose
     String status;
    @SerializedName("currency")
    @Expose
     String currency;
    @SerializedName("listed")
    @Expose
     Boolean listed;
    @SerializedName("shareable")
    @Expose
     Boolean shareable;
    @SerializedName("online_event")
    @Expose
     Boolean onlineEvent;
    @SerializedName("tx_time_limit")
    @Expose
     Integer txTimeLimit;
    @SerializedName("hide_start_date")
    @Expose
     Boolean hideStartDate;
    @SerializedName("hide_end_date")
    @Expose
     Boolean hideEndDate;
    @SerializedName("locale")
    @Expose
     String locale;
    @SerializedName("is_locked")
    @Expose
     Boolean isLocked;
    @SerializedName("privacy_setting")
    @Expose
     String privacySetting;
    @SerializedName("is_series")
    @Expose
     Boolean isSeries;
    @SerializedName("is_series_parent")
    @Expose
     Boolean isSeriesParent;
    @SerializedName("is_reserved_seating")
    @Expose
     Boolean isReservedSeating;
    @SerializedName("source")
    @Expose
     String source;
    @SerializedName("is_free")
    @Expose
     Boolean isFree;
    @SerializedName("version")
    @Expose
     String version;
    @SerializedName("logo_id")
    @Expose
     String logoId;
    @SerializedName("organizer_id")
    @Expose
     String organizerId;
    @SerializedName("venue_id")
    @Expose
     String venueId;
    @SerializedName("category_id")
    @Expose
     String categoryId;
    @SerializedName("subcategory_id")
    @Expose
     String subcategoryId;
    @SerializedName("format_id")
    @Expose
     String formatId;
    @SerializedName("resource_uri")
    @Expose
     String resourceUri;
    @SerializedName("logo")
    @Expose
     Logo logo;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVanityUrl() {
        return vanityUrl;
    }

    public void setVanityUrl(String vanityUrl) {
        this.vanityUrl = vanityUrl;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getCapacityIsCustom() {
        return capacityIsCustom;
    }

    public void setCapacityIsCustom(Boolean capacityIsCustom) {
        this.capacityIsCustom = capacityIsCustom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getListed() {
        return listed;
    }

    public void setListed(Boolean listed) {
        this.listed = listed;
    }

    public Boolean getShareable() {
        return shareable;
    }

    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    public Boolean getOnlineEvent() {
        return onlineEvent;
    }

    public void setOnlineEvent(Boolean onlineEvent) {
        this.onlineEvent = onlineEvent;
    }

    public Integer getTxTimeLimit() {
        return txTimeLimit;
    }

    public void setTxTimeLimit(Integer txTimeLimit) {
        this.txTimeLimit = txTimeLimit;
    }

    public Boolean getHideStartDate() {
        return hideStartDate;
    }

    public void setHideStartDate(Boolean hideStartDate) {
        this.hideStartDate = hideStartDate;
    }

    public Boolean getHideEndDate() {
        return hideEndDate;
    }

    public void setHideEndDate(Boolean hideEndDate) {
        this.hideEndDate = hideEndDate;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getPrivacySetting() {
        return privacySetting;
    }

    public void setPrivacySetting(String privacySetting) {
        this.privacySetting = privacySetting;
    }

    public Boolean getIsSeries() {
        return isSeries;
    }

    public void setIsSeries(Boolean isSeries) {
        this.isSeries = isSeries;
    }

    public Boolean getIsSeriesParent() {
        return isSeriesParent;
    }

    public void setIsSeriesParent(Boolean isSeriesParent) {
        this.isSeriesParent = isSeriesParent;
    }

    public Boolean getIsReservedSeating() {
        return isReservedSeating;
    }

    public void setIsReservedSeating(Boolean isReservedSeating) {
        this.isReservedSeating = isReservedSeating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getFormatId() {
        return formatId;
    }

    public void setFormatId(String formatId) {
        this.formatId = formatId;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

}
