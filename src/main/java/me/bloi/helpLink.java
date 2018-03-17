package me.bloi;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class helpLink extends ListenerAdapter {
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!help")) {
            event.respond("");
        }
    }
}