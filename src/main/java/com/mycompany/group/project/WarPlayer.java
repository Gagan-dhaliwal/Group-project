package com.mycompany.group.project;

import java.util.ArrayList;

public class WarPlayer extends Player {

    private final ArrayList<WarCard> deck;

    public WarPlayer(String name) {
        super(name);
        deck = new ArrayList<>();
    }

    public ArrayList<WarCard> getDeck() {
        return deck;
    }

    @Override
    public void play() {
       
    }
}


