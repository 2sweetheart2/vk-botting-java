package me.sweetie.LongPollStuff;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import me.sweetie.main.Bot;
import me.sweetie.requsts.HttpsRequsts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class LongPoll {
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private String key = null;
    private static String addres = null;
    private String ts;
    private boolean isRunning;

    public LongPoll() {
        HttpsRequsts.method("groups.getLongPollServer", null, (response, code) -> {
            JSONObject response_ = response.getJSONObject("response");
            addres = response_.getString("server");
            key = response_.getString("key");
            ts = response_.getString("ts");
            System.out.println(response_);
            run();
        });
    }

    protected void run() {
        Executors.newSingleThreadExecutor().execute(
                () -> {
                    try {
                        handleUpdates();
                    } catch (Exception e) {
                        run();
                    }
                }
        );
    }

    private void handleUpdates() {
        if (addres == null)
            Bot.log.log(Level.WARNING, "Getting LongPoll server was failed");

        isRunning = true;

        Bot.log.info("LongPoll handler started to handle events");
        try {
            while (isRunning) {
                HttpsRequsts.sendPost("getLongPollServices/" + addres, "key=" + key + "&act=a_check&ts=" + ts + "&wait=" + 10, (response, code) -> {
                    ts = response.getString("ts");
                    System.out.println();
//                    крч надо теперь эту херь за кастить в Event и потом запустить .parse();
//                    for(Object o : response.getJSONArray("updates")) {
//                        gson.fromJson((JsonObject) o, Event.class).parse();
//                    }
                });
            }
        } catch (IOException e) {
            Bot.log.info("LongPoll handler stopped to handle events");
            e.printStackTrace();
        }
        isRunning = false;
    }

    public static String getAddres() {
        return addres;
    }


}