package me.bloi;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.util.ArrayList;
import java.util.Random;

public class Trumpism extends ListenerAdapter {
    private Random rand = new Random();
    private String[] whoToInsult = {
            "Hillary Clinton",
            "ISIS",
            "Barack Obama",
            "America",
            "The CIA",
            "Shuck Schumer",
            "Nancy Pelosi",
            "CNN",
            "Fake News",
            "Robert Mueller",
            "James Comey",
            "Ted Cruise",
            "Liberals",
            "Democrats"
    };
    private String[] negativeAdjectives = {
            "Sleepy",
            "Lazy",
            "Terrible",
            "Sad",
            "Loser",
            "Moron",
            "Lyin",
            "Weak",
            "Frail",
            "Phony",
            "Fraud",
            "Crooked"
    };
    private String[] verbs = {
            "is",
            "are",
            "has",
            "destroyed",
            "hates",
            "criticized",
            "dislikes",
            "loves",
            "created"
    };
    private String[] praiseWorthy = {
            "Freedom",
            "USA",
            "The Wall",
            "Christians",
            "Putin",
            "Confederate Soldiers",
            "White Supremacists",
            "Texas",
            "Coal Miners",
            "Russia"
    };
    private String[] punctuation = {
            ".",
            "?",
            "!!",
            "!",
            " ", //in case of no punctuation
    };
    private String[] exclamation = {
            "Sad",
            "MAGA",
            "Loser",
            "Big Trade Imbalance",
            "No Talent",
            "Wrong",
            "Unwise",
            "Meddling",
            "Republicans",
            "Again",
            " " //in case of nothing
    };
    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!trumpism") || event.getMessage().startsWith("!trump")) {
            //for now, just assemble simple sentences, maybe in future have different sentence structures
            String response = "";
            if (rand.nextBoolean()) {
                response += (negativeAdjectives[rand.nextInt(negativeAdjectives.length - 1)] + " ").toUpperCase();
            } else {
                response += negativeAdjectives[rand.nextInt(negativeAdjectives.length - 1)] + " ";
            }
            if (rand.nextBoolean()) {
                response += (whoToInsult[rand.nextInt(whoToInsult.length - 1)] + " ").toUpperCase();
            } else {
                response += whoToInsult[rand.nextInt(whoToInsult.length - 1)] + " ";
            }
            if (rand.nextBoolean()) {
                response += (verbs[rand.nextInt(verbs.length - 1)] + " ").toUpperCase();
            } else {
                response += verbs[rand.nextInt(verbs.length - 1)] + " ";
            }
            if (rand.nextBoolean()) {
                response += (praiseWorthy[rand.nextInt(praiseWorthy.length - 1)] + punctuation[rand.nextInt(punctuation.length - 1)] + " ").toUpperCase();
            } else {
                response += praiseWorthy[rand.nextInt(praiseWorthy.length - 1)] + punctuation[rand.nextInt(punctuation.length - 1)] + " ";
            }
            if (rand.nextBoolean()) {
                response += (exclamation[rand.nextInt(exclamation.length - 1)] + punctuation[rand.nextInt(punctuation.length - 1)]).toUpperCase();
            } else {
                response += exclamation[rand.nextInt(exclamation.length - 1)] + punctuation[rand.nextInt(punctuation.length - 1)];
            }
            event.respond(response);
        }
    }
}