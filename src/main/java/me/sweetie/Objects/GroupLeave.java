package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class GroupLeave {
    @SerializedName("user_id")
    private int userId;
    @SerializedName("self")
    private int self;

    public int getUserId(){
        return userId;
    }
    public boolean isSelf(){
        return self==1;
    }
}
