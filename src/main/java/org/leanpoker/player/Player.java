package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	String str = request.getAsString();
        System.out.println(str);
    	return 5;
    }

    public static void showdown(JsonElement game) {
    }
}
