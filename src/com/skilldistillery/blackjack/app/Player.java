package com.skilldistillery.blackjack.app;

import java.util.Scanner;

public class Player {
    private Hand hand;

    public Player() {
        // Initialize the player's hand when a Player object is created.
        hand = new Hand();
    }
    	//forgot to let the dealer take is turn, fixed with Dealer dealer
    public void takeTurn(Deck deck, Dealer dealer) {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the player's current hand and total value.
            System.out.println("Your hand: " + hand.getCards());
            System.out.println("Your total value: " + hand.getTotalValue());
            System.out.println("Do you want to HIT or STAND?");

            // Read the player's choice (HIT or STAND) from the console.
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("HIT")) {
                // Deal a card from the deck and add it to the player's hand if there are cards left.
                Card card = deck.dealCard();
                if (card != null) {
                    hand.addCard(card);
                } else {
                    System.out.println("No more cards in the deck.");
                    break;
                }
            } else if (choice.equals("STAND")) {
                // Player chooses to stand and end their turn.
                break;
            } else {
                // Handle an invalid choice by prompting the player to enter HIT or STAND.
                System.out.println("Invalid choice. Please enter HIT or STAND.");
            }

            // Check if the player has busted (total value over 21) and end their turn if so.
            if (hand.getTotalValue() > 21) {
                System.out.println("Bust! Your total value is over 21.");
                break;
            }
        }
        // After the player's turn, dealer's turn.
        dealer.takeTurn(deck);
    }

    public Hand getHand() {
        // Get the player's hand.
        return hand;
    }
}
