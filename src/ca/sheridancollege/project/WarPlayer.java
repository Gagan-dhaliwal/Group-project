package ca.sheridancollege.project;

import java.util.ArrayList;

class WarPlayer extends Player {
    private ArrayList<Card> deck = new ArrayList<>();

    public WarPlayer(String name) {
        super(name);
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void addToDeck(Card card1, Card card2) {
        deck.add(card1);
        deck.add(card2);
    }

    public Card playCard() {
        return deck.remove(0);
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    @Override
    public void play() {

    }
}
