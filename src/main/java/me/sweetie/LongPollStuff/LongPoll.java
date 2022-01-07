package me.sweetie.LongPollStuff;

import me.sweetie.Interfaces.Callback;
import me.sweetie.main.Bot;
import me.sweetie.requsts.HttpsRequsts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class LongPoll extends EventHandler {
    private String key = null;
    private static String addres = null;
    private String ts;

    public LongPoll(String token,int group_id) {
        HttpsRequsts.method("groups.getLongPollServer", "access_token="+token+"&group_id="+group_id+"&v="+5.999, (response, code) -> {
            JSONObject response_ = response.getJSONObject("response");
            addres = response_.getString("server");
            key = response_.getString("key");
            ts = response_.getString("ts");
            run();
        });
    }

    protected void run() {
        Executors.newSingleThreadExecutor().execute(
                () -> {
                    try {
                        handleUpdates();
                    } catch (Exception e) {
                        e.printStackTrace();
                        run();
                    }
                }
        );
    }

    private void handleUpdates() {
        if (addres == null)
            Bot.log.log(Level.WARNING, "Getting LongPoll server was failed");

        Bot.log.info("LongPoll handler started to handle events");
        try {
            while (true) {
                HttpsRequsts.sendPost("getLongPollServices/" + addres, "key=" + key + "&act=a_check&ts=" + ts + "&wait=" + 10, (response, code) -> {
                    if (!ts.equals(response.getString("ts"))) {
                        ts = response.getString("ts");
                        JSONArray a = response.getJSONArray("updates");
                        for (int i = 0; i < a.length(); i++) {
                            JSONObject a_ = (JSONObject) a.get(i);
                            parse(a_.getString("type"), a_.getJSONObject("object"));

                        }
                    }
                });
            }
        } catch (IOException e) {
            Bot.log.info("LongPoll handler stopped to handle events");
            e.printStackTrace();
        }
    }

    public static String getAddres() {
        return addres;
    }

    public void onCommand(String command, Callback callback){
        regCommand(command,callback);
    }
}