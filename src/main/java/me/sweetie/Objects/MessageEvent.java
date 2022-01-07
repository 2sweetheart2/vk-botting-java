package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;

public class MessageEvent {
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("payload")
    private String payload;
    @SerializedName("peer_id")
    private int peerId;

    public String getPayload() {
        return payload;
    }

    public int getUserId() {
        return userId;
    }

    public int getPeerId() {
        return peerId;
    }

    public String getEventId() {
        return eventId;
    }
}
