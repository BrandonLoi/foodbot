package me.bloi;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class helpLink extends ListenerAdapter {
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!helppls") || event.getMessage().equalsIgnoreCase("!foodhelp")) {
            event.respond("https://github.com/BrandonLoi/foodbot/blob/master/commands.md");
        }
    }
}