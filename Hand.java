package student;

/**
 * The Hand class represents a player's hand in a card game.
 * It stores a set of Card objects and allows for operations
 * like drawing from a deck, removing cards, and refilling the hand.
 */
public class Hand {

    /**
    * This makes an array of cards that will be used in the hand.
    */
    private Card[] hand;

    /**
    * intitializing the integer i, that will be sued for indexing and for loops.
    */
    private int i;

    /**
    * This makes a deck tht will be used in the hand class.
    */
    private Deck deck;

    /**
     * This constructor makes a hand by drawing a specified number of cards
     * from the given deck.
     *
     * @param deck the deck to draw cards from
     * @param size the number of cards to initialize in the hand
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        hand = new Card[size];

        for (i = 0; i < size; i++) {
            hand[i] = deck.draw();
        }
    }

    /**
     *
     * @return the number of cards in the hand (size)
     */
    public int getSize() {
        return hand.length;
    }

    /**
     * Retrieves the card at the specified index from the hand.
     * If the index is invalid, it returns the first card in the hand as a fallback.
     *
     * @param i index of card being retrieved
     * @return the card at the specified index, or the first card if the index is invalid
     */
    public Card get(int i) {
        if (i >= hand.length || i < 0) {
            System.out.println("Invalid hand index!");
            return hand[0];
        } else { 
            return hand[i]; }
    }

    /**
     * Removes the specified card from the hand and replaces it with a new card drawn from the deck.
     *
     * @param card the card to be removed
     * @return true if the card was successfully removed, and
     *         false if the card was not found in the hand
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }

        for (int j = 0; j < hand.length; j++) {
            if (hand[j].equals(card)) {
                hand[j] = deck.draw(); // Or shift cards to keep hand intact
                return true;
            }
        }
        return false; // Card not found
    }

    /**
     * Refills the hand by drawing new cards from the deck to replace the null spots.
     * This ensures that the hand is fully refilled, and ready.
     */
    public void refill() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = deck.draw();
            }
        }
    }
}
