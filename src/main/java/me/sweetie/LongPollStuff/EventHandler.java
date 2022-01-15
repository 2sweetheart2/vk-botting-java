package me.sweetie.LongPollStuff;

import com.google.gson.Gson;
import me.sweetie.Objects.*;
import me.sweetie.main.Bot;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

public class EventHandler {
    private final Gson gson = new Gson();
    private final HashMap<String, Object> commands = new HashMap<>();

    protected void onMessageNew(Message message) {
    }

    protected void onMessageTypingState(MessageTypingState type) {
    }

    protected void onMessageEdit(Message message) {
    }

    protected void onGroupLeave(GroupLeave groupLeave) {
    }

    protected void onGroupJoin(GroupJoin groupJoin) {
    }

    protected void onWallPostNew(WallPostNew wallPostNew) {
    }

    protected void onLikeAdd(LikeAdd likeAdd) {
    }

    protected void onLikeRemove(LikeRemove likeRemove) {
    }

    protected void onWallReplyNew(WallReplyNew wallReplyNew) {
    }

    protected void onWallReplyDelete(WallReplyDelete wallReplyDelete) {
    }

    protected void onMessageDeny(MessageDeny messageDeny) {
    }

    protected void onMessageAllow(MessageAllow messageAllow) {
    }

    protected void onSomeEvent(String type, JSONObject object) {
    }

    protected void onMessageEvent(MessageEvent messageEvent) {
    }

    protected void onGroupChatTitleUpdate(String newChatName, Message message) {
    }

    protected void onGroupChatInviteUser(int memberId, Message message) {
    }

    protected void onGroupChatKickUser(int memberId, Message message) {
    }

    protected void onGroupChatPhotoUpdate(Message message) {
    }

    protected void onGroupChatPhotoRemove(Message message) {
    }

    protected void onCommand(Message message, String command, String[] args) {
    }

    private Message currentMessage;

    protected String parse(String type, Object o) {
        switch (type) {
            case "message_new": {
                JSONObject message = ((JSONObject) o).getJSONObject("message");
                Message m = gson.fromJson(message.toString(), Message.class);
                currentMessage = m;
                if (message.has("action")) {
                    JSONObject action = message.getJSONObject("action");
                    switch (action.getString("type")) {
                        case "chat_title_update": {
                            onGroupChatTitleUpdate(action.getString("text"), m);
                            break;
                        }
                        case "chat_invite_user": {
                            onGroupChatInviteUser(action.getInt("member_id"), m);
                            break;
                        }
                        case "chat_kick_user": {
                            onGroupChatKickUser(action.getInt("member_id"), m);
                            break;
                        }
                        case "chat_photo_update": {
                            onGroupChatPhotoUpdate(m);
                            break;
                        }
                        case "chat_photo_remove": {
                            onGroupChatPhotoRemove(m);
                            break;
                        }
                    }
                    break;
                }
                if (m.getText().startsWith(Bot.getPREFIX())) {
                    String r = Search(m.getText().replace(Bot.getPREFIX(), ""));
                    if (r != null) onCommand(currentMessage, r, currentCommand.replace(r, "").split("\\s+"));
                }
                if (!Bot.getBreakAfterCommand()) onMessageNew(m);
                break;
            }
            case "message_typing_state": {
                onMessageTypingState(gson.fromJson(o.toString(), MessageTypingState.class));
                break;
            }
            case "message_edit": {
                Message m = gson.fromJson(o.toString(), Message.class);
                onMessageEdit(m);
                break;
            }
            case "group_leave": {
                onGroupLeave(gson.fromJson(o.toString(), GroupLeave.class));
                break;
            }
            case "group_join": {
                onGroupJoin(gson.fromJson(o.toString(), GroupJoin.class));
                break;
            }
            case "wall_post_new": {
                onWallPostNew(gson.fromJson(o.toString(), WallPostNew.class));
                break;
            }
            case "wall_reply_new": {
                onWallReplyNew(gson.fromJson(o.toString(), WallReplyNew.class));
                break;
            }
            case "wall_reply_delete": {
                onWallReplyDelete(gson.fromJson(o.toString(), WallReplyDelete.class));
            }
            case "like_add": {
                onLikeAdd(gson.fromJson(o.toString(), LikeAdd.class));
                break;
            }
            case "like_remove": {
                onLikeRemove(gson.fromJson(o.toString(), LikeRemove.class));
                break;
            }
            case "message_deny": {
                onMessageDeny(gson.fromJson(o.toString(), MessageDeny.class));
                break;
            }
            case "message_allow": {
                onMessageAllow(gson.fromJson(o.toString(), MessageAllow.class));
                break;
            }
            case "message_event": {
                onMessageEvent(gson.fromJson(o.toString(), MessageEvent.class));
                break;
            }
            default: {
                onSomeEvent(type, (JSONObject) o);
                break;
            }
        }
        return "ok";
    }

    private String currentCommand;

    private String _Search(HashMap<String, Object> map, String[] msg) {
        if (msg.length > 0 && map.containsKey(msg[0])) {
            String res = _Search((HashMap<String, Object>) map.get(msg[0]), Arrays.copyOfRange(msg, 1, msg.length));
            if (res != null) {
                return res;
            }
        }
        if (map.containsKey("")) {
            return (String) map.get("");
        }
        return null;
    }

    private String Search(String name) {
        currentCommand = name;
        return _Search(commands, name.split("\\s+"));
    }

    private void _AddCommand(HashMap<String, Object> map, String[] name, String command) {
        if (name.length == 0) {
            map.put("", command);
            return;
        }
        if (!map.containsKey(name[0])) {
            map.put(name[0], new HashMap<String, Object>());
        }
        _AddCommand((HashMap<String, Object>) map.get(name[0]), Arrays.copyOfRange(name, 1, name.length), command);
    }

    private void AddCommand(String name, String command) {
        _AddCommand(commands, name.split("\\s+"), command);
    }


    protected void regCommand(String command) {

        this.AddCommand(command, command);
    }

}