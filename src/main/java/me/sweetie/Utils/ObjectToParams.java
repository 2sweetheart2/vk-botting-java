package me.sweetie.Utils;

import me.sweetie.Objects.Message;
import me.sweetie.main.Bot;

public class ObjectToParams {
    private static final String token = Bot.getToken();
    private static final Float v = 5.999f;
    public static String castMessageToParams(Message message){
        return addStaticalParams("message=" + message.getMessage() + '&' + "peer_ids=" + message.getPeerId()+'&'+"random_id=0"+'&'+"reply_to="+message.getReplyTo());
    }

    public static String getLongPollServer(){
        return addStaticalParams("group_id="+Bot.getId());
    }
    private static String addStaticalParams(String params){
        return "access_token="+ token+ '&'+"v="+v+'&'+params;
    }
}
