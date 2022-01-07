package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class WallReplyDelete {
    @SerializedName("post_id")
    private int postId;
    @SerializedName("owner_id")
    private int ownerId;
    @SerializedName("deleter_id")
    private int deleterId;
    @SerializedName("id")
    private int id;

    public int getOwnerId() {
        return ownerId;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public int getDeleterId() {
        return deleterId;
    }
}
