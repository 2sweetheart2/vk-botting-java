package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class GroupJoin {
    @SerializedName("join_type")
    private String joinType;
    @SerializedName("user_id")
    private int userId;

    public String getJoinType(){
        return joinType;
    }
    public int getUserId(){
        return userId;
    }
}
