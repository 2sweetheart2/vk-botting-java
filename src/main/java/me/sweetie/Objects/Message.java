package me.sweetie.Objects;

public class Message {
    private String message;
    private int peerId;
    private int replyTo;
    private int fromId;

    public void setFromId(int fromId){
        this.fromId = fromId;
    }

    public int getFromId(){
        return fromId;
    }

    public void setReplyTo(int replyMessageId){
        replyTo=replyMessageId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setPeerId(int peerId){
        this.peerId = peerId;
    }

    public String getMessage() {
        return message;
    }

    public int getPeerId() {
        return peerId;
    }

    public int getReplyTo() {
        return replyTo;
    }
}
