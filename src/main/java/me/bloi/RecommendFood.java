package me.bloi;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class RecommendFood extends ListenerAdapter {
    static ArrayList<String> foodList = null;
    Random rand = null;
    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().startsWith("!food") || event.getMessage().startsWith("what should I eat?")) {
            if (foodList == null) {
                foodList = getFoodList();
            }
            String select = foodList.get(rand.nextInt(foodList.size() - 1));
            event.respond(select);
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
