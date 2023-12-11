package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        // Initialize a new deck of cards when a Deck object is created.
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Fill the deck with all possible combinations of suits and ranks.
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        // Shuffle the deck to randomize the order of cards.
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            // Handle the case where the deck is empty (no more cards to deal).
            return null;
        }
        // Remove and return the top card (the first card in the list).
        return cards.remove(0);
    }
}
