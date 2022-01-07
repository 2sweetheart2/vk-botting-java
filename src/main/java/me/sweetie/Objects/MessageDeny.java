package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class MessageDeny {
    @SerializedName("user_id")
    private int userId;

    public int getUserId() {
        return userId;
    }
}
