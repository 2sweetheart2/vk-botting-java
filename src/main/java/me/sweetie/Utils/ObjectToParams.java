package me.sweetie.Utils;

import me.sweetie.Objects.Message;
import me.sweetie.main.Bot;

public class ObjectToParams {
    private static final String token = Bot.getToken();
    private static final Float v = 5.999f;
    public static String castMessageToParams(Message message){
        return addStaticalParams("message=" + message.getText() + '&' + "peer_ids=" + message.getPeerId()+'&'+"random_id=0"+'&'+"forward="+message.getFwdMessages()[0]);
    }

    private static String addStaticalParams(String params){
        return "access_token="+ token+ '&'+"v="+v+'&'+params;
    }
}
