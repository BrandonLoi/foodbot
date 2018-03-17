package me.bloi;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.net.MalformedURLException;
import java.net.URL;

public class GenerateRobot extends ListenerAdapter {
    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().startsWith("!robot")) {
            String roboText = event.getMessage().substring(7);
            String urlText = "https://robohash.org/" + roboText + ".png";
            try {
                URL x = new URL(urlText);
            } catch (MalformedURLException e) {
                event.respond("uhh.. malformed URL so.. uhh. try again?");
                return;
            }
            event.respond(urlText);
        }
    }
}
