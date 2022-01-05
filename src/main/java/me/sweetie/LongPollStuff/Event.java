package me.sweetie.LongPollStuff;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class Event extends Events {

    @SerializedName("event_id")
    private String event_id;

    @SerializedName("group_id")
    private int group_id;

    @SerializedName("type")
    private String type;

    @SerializedName("object")
    private JSONObject object;

    public void parse(){
        parse(type,object);
    }
}
