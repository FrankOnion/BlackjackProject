package com.skilldistillery.blackjack.app;

public class Card {
    private Suit suit;
    private Rank rank;

    // Constructor to create a Card object with a specified suit and rank.
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter method to retrieve the suit of the card.
    public Suit getSuit() {
        return suit;
    }

    // Getter method to retrieve the rank of the card.
    public Rank getRank() {
        return rank;
    }

    // Override the toString() method to provide a human-readable representation of the card.
    @Override
    public String toString() {
        // The toString() method returns the rank and suit in a readable format.
        // For example, "Ace of Spades" or "King of Hearts".
        return rank + " of " + suit;
    }
}
