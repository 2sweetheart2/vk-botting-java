package me.sweetie.main;

import com.sun.istack.internal.NotNull;
import me.sweetie.LongPollStuff.Event;
import me.sweetie.LongPollStuff.LongPoll;
import me.sweetie.Objects.Message;
import me.sweetie.requsts.HttpsRequsts;

import java.util.logging.Logger;

public class Bot extends Event {
    private static String TOKEN;
    private static Integer ID;
    private LongPoll longPoll = null;
    public static Logger log = Logger.getLogger(Bot.class.getName());
    public Bot(int id, @NotNull String token){
        TOKEN = token;
        ID = id;
        //run(ID);
        longPoll = new LongPoll();

    }

    public static String getToken(){
        return TOKEN;
    }
    public static Integer getId(){
        return ID;
    }

    public void sendMessage(Message message){
        message.setFromId(ID);
        HttpsRequsts.method("messages.send",message,(response, code) -> {});
    }


}
