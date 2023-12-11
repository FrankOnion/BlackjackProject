package com.skilldistillery.blackjack.app;

public class Dealer {
    private Hand hand;

    public Dealer() {
        // Initialize the dealer's hand when a Dealer object is created.
        hand = new Hand();
    }

    public void takeTurn(Deck deck) {
        // The dealer takes their turn in the game.
        // The dealer must hit (draw cards) until their hand total is at least 17.

        while (hand.getTotalValue() < 17) {
            Card card = deck.dealCard();
            if (card != null) {
                // If there are cards left in the deck, the dealer adds a card to their hand.
                hand.addCard(card);
            } else {
                // If there are no more cards in the deck, a message is displayed, and the loop breaks.
                System.out.println("No more cards in the deck.");
                break;
            }
        }
    }

    public Hand getHand() {
        // Get the dealer's hand, which can be used for displaying the dealer's cards.
        return hand;
    }
}
