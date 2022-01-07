package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class LikeAdd {
    @SerializedName("thread_reply_id")
    private int threadReplyId;
    @SerializedName("post_id")
    private int postId;
    @SerializedName("object_type")
    private String objectType;
    @SerializedName("liker_id")
    private int likerId;
    @SerializedName("object_owner_id")
    private int objectOwnerId;
    @SerializedName("object_id")
    private int objectId;

    public int getLikerId() {
        return likerId;
    }

    public int getObjectId() {
        return objectId;
    }

    public int getObjectOwnerId() {
        return objectOwnerId;
    }

    public int getPostId() {
        return postId;
    }

    public int getThreadReplyId() {
        return threadReplyId;
    }

    public String getObjectType() {
        return objectType;
    }
}
