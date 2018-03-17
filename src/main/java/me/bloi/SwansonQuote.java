package me.bloi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SwansonQuote extends ListenerAdapter {
    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!swanson")) {
            String request = "http://ron-swanson-quotes.herokuapp.com/v2/quotes";
            URL url = null;
            try {
                url = new URL(request);
            } catch (MalformedURLException e) {
                event.respond("something is broken, tell iJustWantFoodPls");
                return;
            }
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                String inputLine;
                String x = "";
                while ((inputLine = in.readLine()) != null) {
                    x += inputLine;
                }
                in.close();

                Gson gson = new Gson();

                JsonParser parser = new JsonParser();
                JsonElement o = parser.parse(x);
                String output = o.getAsString();
                event.respond("\"" + output + "\"");

            } catch (Exception e) {
                event.respond("something is broken, tell iJustWantFoodPls");
            }

        }
    }

}
