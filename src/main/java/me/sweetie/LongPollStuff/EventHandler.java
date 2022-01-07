package me.sweetie.LongPollStuff;

import com.google.gson.Gson;
import me.sweetie.Interfaces.Callback;
import me.sweetie.Objects.*;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EventHandler {
    private Gson gson = new Gson();
    private Map<String, Callback> commands = new HashMap<>();

    protected void onMessageNew(Message message) {
    }

    protected void onMessageTypingState(MessageTypingState type){}
    protected void onMessageEdit(Message message){}
    protected void onGroupLeave(GroupLeave groupLeave){}
    protected void onGroupJoin(GroupJoin groupJoin){}
    protected void onWallPostNew(WallPostNew wallPostNew){}
    protected void onLikeAdd(LikeAdd likeAdd){}
    protected void onLikeRemove(LikeRemove likeRemove){}
    protected void onWallReplyNew(WallReplyNew wallReplyNew){}
    protected void onWallReplyDelete(WallReplyDelete wallReplyDelete){}
    protected void onMessageDeny(MessageDeny messageDeny){}
    protected void onMessageAllow(MessageAllow messageAllow){}
    protected void onSomeEvent(String type,JSONObject object){}
    protected void onMessageEvent(MessageEvent messageEvent){}

    protected String parse(String type, Object o) {
        switch (type) {
            case "message_new": {
                JSONObject message = ((JSONObject) o).getJSONObject("message");
                Message m = gson.fromJson(message.toString(), Message.class);
                if (commands.containsKey(m.getText().split(" ")[0]))
                    commands.get(m.getText().split(" ")[0]).cumback(m, Arrays.copyOfRange(m.getText().split(" "), 1, m.getText().split(" ").length));
                onMessageNew(m);
                break;
            }
            case "message_typing_state": {
                onMessageTypingState(gson.fromJson(o.toString(),MessageTypingState.class))  ;
                break;
            }
            case "message_edit":{
                Message m = gson.fromJson(o.toString(), Message.class);
                onMessageEdit(m);
                break;
            }
            case "group_leave":{
                onGroupLeave(gson.fromJson(o.toString(),GroupLeave.class));
                break;
            }
            case "group_join":{
                onGroupJoin(gson.fromJson(o.toString(),GroupJoin.class));
                break;
            }
            case "wall_post_new":{
                onWallPostNew(gson.fromJson(o.toString(), WallPostNew.class));
                break;
            }
            case "wall_reply_new":{
                onWallReplyNew(gson.fromJson(o.toString(),WallReplyNew.class));
                break;
            }
            case "wall_reply_delete":{
                onWallReplyDelete(gson.fromJson(o.toString(),WallReplyDelete.class));
            }
            case "like_add":{
                onLikeAdd(gson.fromJson(o.toString(),LikeAdd.class));
                break;
            }
            case "like_remove":{
                onLikeRemove(gson.fromJson(o.toString(),LikeRemove.class));
                break;
            }
            case "message_deny":{
                onMessageDeny(gson.fromJson(o.toString(),MessageDeny.class));
                break;
            }
            case "message_allow":{
                onMessageAllow(gson.fromJson(o.toString(),MessageAllow.class));
                break;
            }
            case "message_event":{
                onMessageEvent(gson.fromJson(o.toString(),MessageEvent.class));
                break;
            }
            default: {
                onSomeEvent(type, (JSONObject) o);
                break;
            }
        }
        return "ok";
    }

    protected void regCommand(String command, Callback callback) {
        this.commands.put(command, callback);
    }

}