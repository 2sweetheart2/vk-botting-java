package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class WallReplyNew {
    @SerializedName("date")
    private long date;
    @SerializedName("from_id")
    private int fromId;
    @SerializedName("post_id")
    private int postId;
    @SerializedName("parents_stack")
    private int[] parentsIdStack;
    @SerializedName("post_owner_id")
    private int postOwnerId;
    @SerializedName("owner_id")
    private int ownerId;
    @SerializedName("id")
    private int id;
    @SerializedName("text")
    private String text;
    @SerializedName("reply_to_comment")
    private int replyToComment;

    public int getPostId() {
        return postId;
    }

    public long getDate() {
        return date;
    }

    public int getFromId() {
        return fromId;
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getText() {
        return text;
    }

    public int getPostOwnerId() {
        return postOwnerId;
    }

    public int getReplyToComment() {
        return replyToComment;
    }

    public int[] getParentsIdStack() {
        return parentsIdStack;
    }
}
