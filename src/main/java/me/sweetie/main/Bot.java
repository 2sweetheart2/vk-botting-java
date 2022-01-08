package me.sweetie.main;

import com.sun.istack.internal.NotNull;
import me.sweetie.Interfaces.ProcessOutput;
import me.sweetie.Objects.Message;
import me.sweetie.requsts.HttpsRequsts;

import java.io.IOException;
import java.util.logging.Logger;

public class Bot {
    private static String TOKEN;
    private static Integer ID;
    public static Logger log = Logger.getLogger(Bot.class.getName());
    private static boolean flag = false;

    public Bot(int id, @NotNull String token) {
        TOKEN = token;
        ID = id;
    }

    public void setBreakAfterCommand(boolean flag) {
        this.flag = flag;
    }

    public static boolean getBreakAfterCommand() {
        return flag;
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

    public void sendMethd(String method, String args, ProcessOutput callback) {
        try {
            HttpsRequsts.sendPost(method, args, callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
