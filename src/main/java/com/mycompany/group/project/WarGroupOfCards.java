package com.mycompany.group.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarGroupOfCards extends GroupOfCards {

    public WarGroupOfCards() {
        super(52); 
        createDeck();
        shuffle();
    }

    private void createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                WarCard card = new WarCard(suit, rank);
                getCards().add(card);
            }
        }
    }
}
