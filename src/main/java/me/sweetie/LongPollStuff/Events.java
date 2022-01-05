package me.sweetie.LongPollStuff;

import me.sweetie.main.Bot;

public abstract class Events{
    private static final String OVERRIDING_ERR = "Method of handling event is not overridden";
    protected void onMessageNew(Object o){
        Bot.log.info(OVERRIDING_ERR);
    }


    protected void parse(String type, Object o){
        switch (type){
            case "message_new":{
                onMessageNew(o);
            }
        }
    }
}