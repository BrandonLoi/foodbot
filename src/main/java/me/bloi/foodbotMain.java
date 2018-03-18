package me.bloi;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class foodbotMain extends ListenerAdapter {
    @Override
    // Set mode +B for Bots
    public void onConnect(ConnectEvent event) {
        event.getBot().sendRaw().rawLine("mode " + event.getBot().getNick() + " +B");
    }
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
                .addAutoJoinChannel("#dtella") //Join a channel
                .addListener(new foodbotMain()) //Add THIS listener that will be called on Events
                .addListener(new RecommendFood())
                .addListener(new coinLookup())
                .addListener(new SwansonQuote())
                .addListener(new GenerateRobot())
                .addListener(new helpLink())
                .addListener(new Trumpism())
                .buildConfiguration();

        //Create our bot with the configuration
        PircBotX bot = new PircBotX(configuration);
        //Connect to the server
        bot.startBot();
    }
}