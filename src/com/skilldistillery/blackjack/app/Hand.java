package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        // Create a new ArrayList to store cards for this hand
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        // Add a card to the hand
        cards.add(card);
    }

    public int getTotalValue() {
        int totalValue = 0;
        int numAces = 0;

        // Calculate the total value of the hand by evaluating each card
        for (Card card : cards) {
            Rank rank = card.getRank();

            if (rank == Rank.ACE) {
                numAces++;
                totalValue += 11; // Assuming Ace as 11 initially
            } else if (rank == Rank.TEN || rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
                totalValue += 10; // Face cards are worth 10 points
            } else {
                totalValue += rank.ordinal() + 2; // For other ranks, use their ordinal value + 2
            }
        }

        // Adjust for Aces if the total value is over 21
        while (totalValue > 21 && numAces > 0) {
            totalValue -= 10; // Change the value of an Ace from 11 to 1 to avoid busting
            numAces--;
        }

        return totalValue; // Return the final total value of the hand
    }

    public List<Card> getCards() {
        return cards; // Get a list of all cards in the hand
    }

    public void clear() {
        // Clear all cards from the hand
        cards.clear();
    }
}
