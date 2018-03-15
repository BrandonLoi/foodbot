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

public class coinLookup extends ListenerAdapter{
    @Override
    public void onMessage(MessageEvent event) {
         String request = "https://min-api.cryptocompare.com/data/price?";

        if (event.getMessage().startsWith("!coin ")) {
            String coinName = event.getMessage().substring(6).toUpperCase();
            String[] list = coinName.split(" ");


            URL url = null;
            try {
                url = new URL(request + "fsym=" + coinName + "&tsyms=" + "USD");
            } catch (MalformedURLException e) {
                event.respond("malformed request :(");
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
                //String output = gson.fromJson(x, String.class); //WRONG

                JsonParser parser = new JsonParser();
                JsonObject o = parser.parse(x).getAsJsonObject();
                JsonElement blah = o.get("USD");
                String output = Double.toString(blah.getAsDouble());

                event.respond(  coinName + " : " +"$" + output);

            } catch (Exception e) {
                event.respond("something is broken, tell iJustWantFoodPls");
            }

        }
    }
}
