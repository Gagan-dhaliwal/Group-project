/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.group.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gagan
 */
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of play method, of class WarGame.
     */
    /*@Test
    public void testPlay() {
        System.out.println("play");
        WarGame instance = new WarGame("Testing Game");
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of cardsDivide method, of class WarGame.
     */
    @Test
    public void testCardsDivide() {
        System.out.println("cardsDivide");
           WarGame warGame = new WarGame("Test Game");

    // Simulate user choice by directly setting the player names
    warGame.getPlayer1().setName("Player 1");
    warGame.getPlayer2().setName("Player 2");

    warGame.cardsDivide();

    // Assert the expected number of cards for each player
    assertEquals(7, warGame.getPlayer1().getDeck().size());
    assertEquals(7, warGame.getPlayer2().getDeck().size());

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of playerTurn method, of class WarGame.
     */
    @Test
    public void testPlayerTurn() {
        System.out.println("Player turn");
     WarGame warGame = new WarGame("Test Game");

    // Simulate player names
    warGame.getPlayer1().setName("Player 1");
    warGame.getPlayer2().setName("Player 2");

    // Simulate player turn for player 1
    warGame.getPlayer1().getDeck().add(new WarCard("Hearts", "2"));
    warGame.playerTurn(warGame.getPlayer1());
    assertEquals(0, warGame.getPlayer1().getDeck().size());

    // Simulate player turn for player 2
    warGame.getPlayer2().getDeck().add(new WarCard("Diamonds", "3"));
    warGame.playerTurn(warGame.getPlayer2());
    assertEquals(0, warGame.getPlayer2().getDeck().size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cardCompare method, of class WarGame.
     */
    @Test
    public void testCardCompare() {
        System.out.println("compare Cards");
         WarGame warGame = new WarGame("Test Game");
    WarPlayer player = new WarPlayer("Player 1");

    // Simulate player names
    warGame.getPlayer1().setName("Player 1");
    warGame.getPlayer2().setName("Player 2");

    // Simulate card comparison
    WarCard card1 = new WarCard("Hearts", "5");
    WarCard card2 = new WarCard("Clubs", "7");
    warGame.cardCompare(card1, player);
    assertEquals(1, player.getDeck().size());
    warGame.cardCompare(card2, player);
    assertEquals(2, player.getDeck().size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of handleTie method, of class WarGame.
     */
    /*@Test
    public void testHandleTie() {
        System.out.println("handleTie");
        WarGame warGame = new WarGame("Test Game");
         WarCard card1 = new WarCard("Hearts", "King");
        WarCard card2 = new WarCard("Clubs", "King");
        warGame.getPlayer1().getDeck().add(card1);
        warGame.getPlayer2().getDeck().add(card2);
        
        warGame.handleTie(card1, card2);
        assertEquals(0, warGame.getPlayer1().getDeck().size());
        assertEquals(0, warGame.getPlayer2().getDeck().size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of declareWinner method, of class WarGame.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("winner declaration");
        WarGame warGame = new WarGame("Test Game");

    // Simulate player names
    warGame.getPlayer1().setName("Player 1");
    warGame.getPlayer2().setName("Player 2");

    // Simulate declaring winner
    warGame.getPlayer1().getDeck().add(new WarCard("Hearts", "Ace"));
    warGame.declareWinner();
    assertEquals("Player 1 wins!", warGame.getWinnerMessage());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of declareStalemate method, of class WarGame.
     */
    @Test
    void testDeclareStalemate() {
        System.out.println("Stalemate");
         WarGame warGame = new WarGame("Test Game");

    // Simulate player names
    warGame.getPlayer1().setName("Player 1");
    warGame.getPlayer2().setName("Player 2");

    // Simulate declaring stalemate
    warGame.declareStalemate();
    assertEquals("Continuous tie (Stalemate)!" + System.lineSeparator() +
                 "Final result:" + System.lineSeparator() +
                 "Player 1's deck size: 0" + System.lineSeparator() +
                 "Player 2's deck size: 0" + System.lineSeparator() +
                 "There is no winner. It's a draw!", warGame.getStalemateMessage());
}
    }
   
}
