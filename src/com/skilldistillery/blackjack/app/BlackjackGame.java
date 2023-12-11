package com.skilldistillery.blackjack.app;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner input;

    public BlackjackGame() {
        // Initialize the game by creating deck, player, dealer, and scanner
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        input = new Scanner(System.in);
    }

    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            // Shuffle and deal the first hands for each round
            deck.shuffle();
            dealInitialHands();

            while (!isGameOver()) {
                displayGameState();

                // Player gets the first turn
                player.takeTurn(deck, dealer);

                if (!isGameOver()) {
                    // Dealer goes when player stays
                    dealer.takeTurn(deck);
                }
            }

            // Determine the winner and display the result.
            whoWon();

            System.out.print("Play again? (Y/N): ");
            String choice = input.next().trim().toLowerCase();

            if (!choice.equals("y")) {
                playAgain = false;
            } else {
                // Reset for new round
                player.getHand().clear();
                dealer.getHand().clear();
            }
        }

        // Close the scanner and say bye
        input.close();
        System.out.println("Come back soon!");
    }

    private void dealInitialHands() {
        // Deal starting cards
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
    }

    public void displayGameState() {
        // Showing player's hand and dealer's upward card
        System.out.println("Player's hand: " + player.getHand().getCards());
        System.out.println("Player's total value: " + player.getHand().getTotalValue());
        System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [Face Down Card]");
    }

    public boolean isGameOver() {
        // Determine if it's game over
        int playerTotal = player.getHand().getTotalValue();
        int dealerTotal = dealer.getHand().getTotalValue();

        return playerTotal >= 21 || dealerTotal >= 21 || (playerTotal == 21 && dealerTotal == 21);
    }

    private void whoWon() {
        // Determine winner
        int playerTotal = player.getHand().getTotalValue();
        int dealerTotal = dealer.getHand().getTotalValue();

        System.out.println("Player's hand: " + player.getHand().getCards() + " (Total: " + playerTotal + ")");
        System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " (Total: " + dealerTotal + ")");

        if (playerTotal > 21 || (dealerTotal <= 21 && dealerTotal >= playerTotal)) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Player wins!");
        }
    }

    public static void main(String[] args) {
        // Create a BlackjackGame instance and start the game
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    }
}
