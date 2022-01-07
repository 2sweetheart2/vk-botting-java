package me.sweetie.Objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

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
    private JsonArray attachments;
    @SerializedName("is_hidden")
    private boolean isHidden;
    @SerializedName("fwd_messages")
    private JsonArray fwdMessages;
    @SerializedName("id")
    private int id;
    @SerializedName("conversation_message_id")
    private int convMessageId;

    private KeyBoard keyBoard;

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getKeyBoard() {
        JSONObject keyboard = new JSONObject();
        keyboard.put("one_time", this.keyBoard.getOneTime());
        keyboard.put("buttons", this.keyBoard.getButtonsAsJson());
        return keyboard.toString();
    }

    public Message setText(String message) {
        this.text = message;
        return this;
    }

    public Message setPeerId(int peerId) {
        this.peerId = peerId;
        return this;
    }

    public Message setConvMessageId(int id) {
        this.convMessageId = id;
        return this;
    }


    public String getText() {
        return text;
    }

    public int getPeerId() {
        return peerId;
    }

    public long getDate() {
        return date;
    }

    public boolean isImportant() {
        return important;
    }

    public int getFromId() {
        return fromId;
    }

    public Object getAttachments() {
        return attachments;
    }

    public Object getFwdMessages() {
        return fwdMessages;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getId() {
        return id;
    }

    public int getConvMessageId() {
        return convMessageId;
    }

    public void setReply(Message message) {
        setPeerId(message.getPeerId());
        JsonElement j = new JsonParser().parse((String.format("{\"peer_id\":%s,\"is_reply\":\"%s\",\"conversation_message_ids\":%s}", message.getPeerId(), getText(), message.getConvMessageId()))).getAsJsonObject();
        JsonArray j_ = new JsonArray();
        j_.add(j);
        fwdMessages = j_;
    }
}
