package me.bloi;

import org.apache.commons.lang3.ObjectUtils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class RecommendFood extends ListenerAdapter {
    static ArrayList<String> foodList = null;
    static ArrayList<String> iList = null;
    Random rand = null;
    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("!foodpls") || event.getMessage().equalsIgnoreCase("what should I eat?")) {
            if (foodList == null) {
                foodList = getFoodList();
                if (foodList == null) {
                    return;
                }
            }
            String select = foodList.get(rand.nextInt(foodList.size() - 1));
            event.respond(select);
        }
        if (event.getMessage().startsWith("!ingredient")) {
            if (iList == null) {
                iList = getIList();
                if (iList == null) {
                    return;
                }
            }
            event.respond(iList.get(rand.nextInt(iList.size() - 1)));
        }
    }

    private ArrayList<String> getIList() {
        try {
            Scanner file = new Scanner(new File("ingredients.txt"));
            ArrayList<String> i =  new ArrayList<String>();
            while (file.hasNext()) {
                i.add(file.next());
            }
            file.close();
            return i;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    private ArrayList<String> getFoodList() {
        try {
            Scanner file = new Scanner(new File("foodsList.txt"));
            ArrayList<String> foods =  new ArrayList<String>();
            while (file.hasNext()) {
                foods.add(file.next());
            }
            file.close();
            return foods;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    RecommendFood() {
        rand = new Random();
        foodList = getFoodList();
    }
}
