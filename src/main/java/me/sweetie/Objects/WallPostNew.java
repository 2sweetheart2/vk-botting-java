package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class WallPostNew {
    @SerializedName("date")
    private long date;
    @SerializedName("from_id")
    private int fromId;
    @SerializedName("comments")
    private JSONObject commnets;
    @SerializedName("is_favorite")
    private boolean isFavorite;
    @SerializedName("owner_id")
    private int ownerId;
    @SerializedName("can_edit")
    private int canEdit;
    @SerializedName("created_by")
    private int createdById;
    @SerializedName("short_text_rate")
    private float shotTextRate;
    @SerializedName("can_delete")
    private int canDelete;
    @SerializedName("donut")
    private JSONObject donut;
    @SerializedName("marked_as_ads")
    private int markedAsAds;
    @SerializedName("post_type")
    private String postType;
    @SerializedName("id")
    private int id;
    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public boolean getMarkedAsAds() {
        return markedAsAds==1;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public int getId() {
        return id;
    }

    public int getFromId() {
        return fromId;
    }

    public int getCreatedById() {
        return createdById;
    }

    public boolean getCanEdit() {
        return canEdit==1;
    }

    public boolean getCanDelete() {
        return canDelete==1;
    }

    public float getShotTextRate() {
        return shotTextRate;
    }

    public JSONObject getCommnets() {
        return commnets;
    }

    public JSONObject getDonut() {
        return donut;
    }

    public long getDate() {
        return date;
    }

    public String getPostType() {
        return postType;
    }
}
