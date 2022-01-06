package me.sweetie.main;

import com.sun.istack.internal.NotNull;
import me.sweetie.Objects.Message;
import me.sweetie.requsts.HttpsRequsts;

import java.util.logging.Logger;

public class Bot {
    private static String TOKEN;
    private static Integer ID;
    public static Logger log = Logger.getLogger(Bot.class.getName());
    public static String PREFIX = null;

    public Bot(int id, @NotNull String token, String prefix) {
        TOKEN = token;
        ID = id;
        PREFIX = prefix;
    }

    public static String getToken() {
        return TOKEN;
    }

    public static Integer getId() {
        return ID;
    }

    public boolean sendMessage(Message message) {
        HttpsRequsts.method("messages.send", message, (response, code) -> {
        });
        return true;
    }


}
