package me.sweetie.Objects;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("date")
    private long date;
    @SerializedName("sizes")
    private JsonArray sizes;
    @SerializedName("owner_id")
    private int ownerId;
    @SerializedName("has_tags")
    private boolean hasTags;
    @SerializedName("id")
    private int id;
    @SerializedName("text")
    private String text;

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public boolean isHasTags() {
        return hasTags;
    }

    public JsonArray getSizes() {
        return sizes;
    }
}
