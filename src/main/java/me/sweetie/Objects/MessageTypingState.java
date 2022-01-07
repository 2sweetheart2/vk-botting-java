package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class MessageTypingState {

    @SerializedName("from_id")
    private int fromId;
    @SerializedName("state")
    private String state;

    public String getState() {
        return state;
    }

    public int getFromId() {
        return fromId;
    }

}
