package me.sweetie.Objects;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;

public class Message {

    @SerializedName("text")
    private String text;
    @SerializedName("peer_id")
    private int peerId;
    @SerializedName("date")
    private long date;
    @SerializedName("important")
    private boolean important;
    @SerializedName("from_id")
    private int fromId;
    @SerializedName("attachments")
    private Object[] attachments;
    @SerializedName("is_hidden")
    private boolean isHidden;
    @SerializedName("fwd_messages")
    private Object[] fwdMessages;
    @SerializedName("id")
    private int id;
    @SerializedName("conversation_message_id")
    private int convMessageId;



    public void setText(String message) {
        this.text = message;
    }
    public void setPeerId(int peerId){
        this.peerId = peerId;
    }
    public void setConvMessageId(int id){
        this.convMessageId = id;
    }


    public String getText() {
        return text;
    }

    public int getPeerId() {
        return peerId;
    }

    public long getDate(){
        return date;
    }

    public boolean isImportant(){
        return important;
    }

    public int getFromId(){
        return fromId;
    }
    public Object[] getAttachments(){
        return attachments;
    }
    public Object[] getFwdMessages(){
        return fwdMessages;
    }
    public boolean isHidden(){
        return isHidden;
    }
    public int getId(){
        return id;
    }
    public int getConvMessageId(){
        return convMessageId;
    }

    public void setReply(Message message) {
        setPeerId(message.getPeerId());
        fwdMessages = Collections.singletonList(new JSONObject(String.format("{\"peer_id\":%s,\"is_reply\":\"%s\",\"conversation_message_ids\":%s}", message.getPeerId(), getText(), message.getConvMessageId()))).toArray();
    }
}
