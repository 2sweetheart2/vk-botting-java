package me.sweetie.LongPollStuff;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.sweetie.Objects.Message;
import me.sweetie.main.Bot;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EventHandler {
    private static final String ERROR = "some problem with LongPoll";
    private final Logger log = Bot.log;
    private Gson gson = new Gson();

    protected void onMessageNew(Message message) {
    }

    protected void onCommand(Message message){
    }

    protected String parse(String type, Object o) {
        switch (type) {
            case "message_new": {
                JSONObject message = ((JSONObject) o).getJSONObject("message");
                Message m = gson.fromJson(message.toString(), Message.class);
                if(message.getString("text").startsWith(Bot.PREFIX))
                    onCommand(m);
                else
                    onMessageNew(m);
            }
        }
        return "ok";
    }


}