package com.mycompany.group.project;
import java.util.ArrayList;
import java.util.Scanner;

public class WarGame extends Game {

    private WarGroupOfCards deck;
    private final WarPlayer player1;
    private final WarPlayer player2;
    private final Scanner scan;
    private final int maxConsecutiveTies = 3; 
  public WarPlayer getPlayer1() {
        return player1;
    }

    public WarPlayer getPlayer2() {
        return player2;
    }

    public WarGame(String name) {
        super(name);
        deck = new WarGroupOfCards();
        scan = new Scanner(System.in);

        System.out.println("Enter '1' to play with the computer or '2' to play with another player:\n-----------");
        int choose= scan.nextInt();
        scan.nextLine(); 

        if (choose== 1) {
            System.out.println("Enter Player 1's name:");
            String name1 = scan.nextLine();
            player1 = new WarPlayer(name1);
            player2 = new WarComputerPlayer("Computer");
        } else {
            System.out.println("Enter Player 1's name:");
            String name1 = scan.nextLine();
            player1 = new WarPlayer(name1);

            System.out.println("Enter Player 2's name:");
            String name2 = scan.nextLine();
            player2 = new WarPlayer(name2);
        }
    }
    @Override
    public void play() {
        cardsDivide();
        int consecutiveTies = 0;
        while (!player1.getDeck().isEmpty() && !player2.getDeck().isEmpty()) {
            playerTurn(player1);
            playerTurn(player2);

            if (player1.getDeck().isEmpty() || player2.getDeck().isEmpty()) {
                break;
            } else if (player1.getDeck().get(0).getRank().equals(player2.getDeck().get(0).getRank())) {
                consecutiveTies++;
            } else {
                consecutiveTies = 0;
            }
            if (consecutiveTies >= maxConsecutiveTies) {
                declareStalemate();
                break;

                
            }
        }
    }
public void cardsDivide() {
        ArrayList<Card> cards = deck.getCards();
        //int divided = deck.getSize() / 2;
        int divided = 7;
        for (int i = 0; i < divided; i++) {
            player1.getDeck().add((WarCard) cards.remove(0));
            player2.getDeck().add((WarCard) cards.remove(0));
        }
    }
    public void playerTurn(WarPlayer player) {
        System.out.println("Press Enter to continue to the next round...");
        scan.nextLine();
        
        if (!player.getDeck().isEmpty()) {
            WarCard card = player.getDeck().remove(0);
            System.out.println(player.getName() + " plays: " + card);
    
            cardCompare(card, player);
    
            System.out.println("Scoreboard:");
            System.out.println(player1.getName() + "'s deck size: " + player1.getDeck().size());
            System.out.println(player2.getName() + "'s deck size: " + player2.getDeck().size());
        } else {
            System.out.println(player.getName() + "'s deck is empty!");
        }
    }
    

    public void cardCompare(WarCard card, WarPlayer player) {
        WarPlayer player3 = (player == player1) ? player2 : player1;
        if (!player3.getDeck().isEmpty()) {
            WarCard card3 = player3.getDeck().remove(0);
            System.out.println(player3.getName() + " plays: " + card3);
    
            int comparison = card.getRank().compareTo(card3.getRank());
    
            if (comparison > 0) {
                player.getDeck().add(card);
                player.getDeck().add(card3);
                System.out.println(player.getName() + " wins the round\n-----------");
            } else if (comparison < 0) {
                player3.getDeck().add(card);
                player3.getDeck().add(card3);
                System.out.println(player3.getName() + " wins the round\n-----------");
            } else {
                handleTie(card, card3);
            }
        }
    }
    

    public void handleTie(WarCard card1, WarCard card2) {
        System.out.println("It's a tie! Going to war...\n");
        int faceDownCards = 3;
        boolean isItTie = true;
        ArrayList<WarCard> tieCards = new ArrayList<>();
        tieCards.add(card1);
        tieCards.add(card2);

        while (isItTie) {
            if (player1.getDeck().size() < faceDownCards + 1 || player2.getDeck().size() < faceDownCards + 1) {
                declareWinner();
                isItTie = false;
                break;
            }

            for (int i = 0; i < faceDownCards; i++) {
                tieCards.add(player1.getDeck().remove(0));
                tieCards.add(player2.getDeck().remove(0));
            }
            if (player1.getDeck().size() < 1 || player2.getDeck().size() < 1) {
                declareWinner();
                isItTie = false;
                break;
            }
            WarCard lastCard1 = player1.getDeck().get(0);
            WarCard lastCard2 = player2.getDeck().get(0);
            System.out.println("Player 1 plays: " + lastCard1);
            System.out.println("Player 2 plays: " + lastCard2);

            int comparison = lastCard1.getRank().compareTo(lastCard2.getRank());

            if (comparison > 0) {
                player1.getDeck().addAll(tieCards);
                System.out.println("Player 1 wins the war!");
            } else if (comparison < 0) {
                player2.getDeck().addAll(tieCards);
                System.out.println("Player 2 wins the war!");
            } else {
                System.out.println("Another tie! War continues...");
                tieCards.clear();
                tieCards.add(lastCard1);
                tieCards.add(lastCard2);
            }

            isItTie = false; 
        }
    }

    @Override
    public void declareWinner() {
        int player1DeckSize = player1.getDeck().size();
        int player2DeckSize = player2.getDeck().size();

        System.out.println("Final result:");
        System.out.println(player1.getName() + "'s deck size: " + player1DeckSize);
        System.out.println(player2.getName() + "'s deck size: " + player2DeckSize);

        if (player1DeckSize > player2DeckSize) {
            System.out.println(player1.getName() + " wins!");
        } else if (player1DeckSize < player2DeckSize) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a draw! No winner.");
        }

    }
    public String getWinnerMessage() {
        int player1DeckSize = player1.getDeck().size();
        int player2DeckSize = player2.getDeck().size();

        if (player1DeckSize > player2DeckSize) {
            return player1.getName() + " wins!";
        } else if (player1DeckSize < player2DeckSize) {
            return player2.getName() + " wins!";
        } else {
            return "It's a draw! No winner.";
        }
    }
   public void declareStalemate() {
        System.out.println("Continuous tie (Stalemate)!");
        System.out.println("Final result:");
        System.out.println(player1.getName() + "'s deck size: " + player1.getDeck().size());
        System.out.println(player2.getName() + "'s deck size: " + player2.getDeck().size());
        System.out.println("There is no winner. It's a draw!");
    }
   public String getStalemateMessage() {
        return "Continuous tie (Stalemate)!" + System.lineSeparator() +
               "Final result:" + System.lineSeparator() +
               player1.getName() + "'s deck size: " + player1.getDeck().size() + System.lineSeparator() +
               player2.getName() + "'s deck size: " + player2.getDeck().size() + System.lineSeparator() +
               "There is no winner. It's a draw!";
    }

}
