package me.bloi;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class foodbotMain extends ListenerAdapter {
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        //When someone says ?helloworld respond with "Hello World"
        if (event.getMessage().startsWith("?helloworld"))
            event.respond("Hello world!");
    }

    public static void main(String[] args) throws Exception {
        org.apache.log4j.BasicConfigurator.configure();

        //Configure what we want our bot to do
        Configuration configuration = new Configuration.Builder()
                .setName("foodbot") //Set the nick of the bot
                .addServer("irc.dtella.net") //Join the freenode network
                .addAutoJoinChannel("#bots") //Join the bot channel
                .addListener(new foodbotMain()) //Add THIS listener that will be called on Events
                .addListener(new RecommendFood())
                .buildConfiguration();

        //Create our bot with the configuration
        PircBotX bot = new PircBotX(configuration);
        //Connect to the server
        bot.startBot();
    }
}