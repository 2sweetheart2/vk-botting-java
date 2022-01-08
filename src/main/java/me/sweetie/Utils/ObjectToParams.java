package me.sweetie.Utils;

import me.sweetie.Objects.Message;
import me.sweetie.main.Bot;

import java.util.logging.Level;

public class ObjectToParams {
    private static final String token = Bot.getToken();
    private static final Float v = 5.999f;

    public static String castMessageToParams(Message message) {
        StringBuilder text = new StringBuilder();
        if (message.getText() == null) {
            Bot.log.log(Level.WARNING, "the message must have the text");
            return "false";
        } else text.append("message=").append(message.getText()).append("&");
        if (message.getPeerId() < 1000000000) return "incorrect peer id";
        else text.append("peer_ids=").append(message.getPeerId()).append("&");
        if (message.getBotFwdMessage() != null)
            text.append("forward=").append(message.getBotFwdMessage().toString()).append('&');
        if (message.getAttachments() != null)
            text.append("attachment=").append(message.getAttachments().toString()).append('&');
        if (message.getKeyBoard() != null) text.append("keyboard=").append(message.getKeyBoard()).append('&');
        text.append("random_id=0");
        return addStaticalParams(text.toString());
    }

    private static String addStaticalParams(String params) {
        return "access_token=" + token + '&' + "v=" + v + '&' + params;
    }
}
