package com.mycompany.group.project;

/**
 * A class that represents a War card with a specific suit and rank.
 * Extends the abstract Card class.
 * Students can modify this class to include additional card properties if needed.
 * Add your name as an author and the date!
 *
 * @author dancye
 */
public class WarCard extends Card {

    private final String suit;
    private final String rank;

    public WarCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

