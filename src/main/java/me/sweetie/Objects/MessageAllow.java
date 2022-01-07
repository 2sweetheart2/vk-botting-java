package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class MessageAllow {
    @SerializedName("user_id")
    private int userId;
    @SerializedName("key")
    private String key;

    public int getUserId() {
        return userId;
    }

    public String getKey() {
        return key;
    }
}
