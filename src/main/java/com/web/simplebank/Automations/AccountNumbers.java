package com.web.simplebank.Automations;

import java.util.UUID;

public class AccountNumbers {
    public static String AccountNumbers(){
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
