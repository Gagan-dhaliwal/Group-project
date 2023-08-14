package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarGame extends Game {

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        GroupOfCards deck = new GroupOfCards(52);

        deck.shuffle();

        ArrayList<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCardToDeck(cards.get(i));
            } else {
                player2.addCardToDeck(cards.get(i));
            }
        }

        while (!player1.isDeckEmpty() && !player2.isDeckEmpty()) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            int result = card1.compareTo(card2);
            if (result > 0) {
                player1.addToDeck(card1, card2);
            } else if (result < 0) {
                player2.addToDeck(card1, card2);
            } else {
                
            }
        }
    }

    @Override
    public void declareWinner() {
        WarPlayer winner = determineWinner();
        System.out.println("The winner is: " + winner.getName());
    }

    private WarPlayer determineWinner() {

        return null;
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame("War Game");
        warGame.play();
        warGame.declareWinner();
    }
}
