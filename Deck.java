package student;

import java.util.Random;

/**
 * The Deck class represents a standard deck of 52 playing cards.
 * It allows for shuffling the deck, drawing cards, and checking if the deck is empty.
 */
public class Deck {

   /**
    * This makes an array of cards that will be used in the hand.
    */
    private Card[] deck;

   /**
    * This tracks the current index, and allows for us to know if the deckis empty or not.
    */
    private int currentIndex = 0;

    /**
     * This is the decks constructor, and it Constructs a new deck of 52 cards.
     * The deck consists of 13 ranks and 4 suits. The deck is shuffled in the beginning.
     */
    public Deck() {

        deck = new Card[52];
        int index = 0;

        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck[index] = new Card(rank, suit);
                index++;

            }
        }

        shuffle();
}

    /**
     * Shuffles the deck of cards using the Fisher-Yates shuffle algorithm.
     * This algorithm ensures a random order of cards in the deck.
     */
    public void shuffle() {
        Random r = new Random();

        for (int i = deck.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Draws the next card from the deck. If the deck is empty the deck gets reshuffled,
     * and drawing starts from the beginning.
     *
     * @return the next card in the deck
     */
    public Card draw() {
        if (currentIndex >= deck.length) {
            shuffle();
            currentIndex = 0;
        }

        Card nextCard = deck[currentIndex];
        currentIndex++;
        return nextCard;

    }

    /**
     *
     * @return the number of remaining cards in the deck
     */
    public int cardsRemaining() {
        return deck.length - currentIndex;
    }

    /**
     *
     * @return true if the deck is empty, and false otherwise
     */
    public boolean isEmpty() {
        if (deck.length == currentIndex) {
            return true;
        }
        return false;
    }

}
