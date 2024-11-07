package student;

/**
 * This class represents a pile of cards in a card game.
 * This class enforces rules for playing a new card on the pile
 * based on the game's rules.
 */
public class CardPile {

    /**
     * Array representing the cards in the pile.
     */
    private Card[] c1;

    /**
     * Index representing the position of the top card in the pile.
     */
    private int topIndex;

    /**
     * This constructor makes a new card pile with an initial top card.
     * If the top card is null, the pile is initialized as empty.
     *
     * @param topCard The first card placed on top of the pile, or null for an empty pile.
     */
    public CardPile(Card topCard) {
        c1 =  new Card[52];
        topIndex = 0;
        if(topCard == null) {
            return;
        }
        c1[0] = topCard; // Set the top card
        topIndex = 1;

    }

    /**
     * Determines whether the given card can be legally played on the pile.
     * A card can be played if: The pile is empty, or The card has a higher
     * rank than the top card, or The card has the same suit as the top card.
     *
     * @param card The card to check if its able to be played.
     * @return true if the card can be legally played, false otherwise.
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            System.out.println("Illegal move detected!");
            return false;
        }

        if (topIndex == 0) {
            return true;
        }

        Card topCard = c1[topIndex - 1];

        return (card.getRankNum() > topCard.getRankNum() || card.getSuitNum() == topCard.getSuitNum());
    }

    /**
     * Plays a card by adding it to the top of the pile, if it is a legal move.
     * If the card cannot be played, an IllegalArgumentException is thrown.
     *
     * @param card The card to be played.
     * @throws IllegalArgumentException if the card cannot be legally played.
     */
    public void play(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if (!canPlay(card)) {
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if (topIndex < c1.length) {
            c1[topIndex] = card;
            topIndex ++;
        } else {
            return;
        }
    }

    /**
     *
     * @return The number of cards in the pile.
     */
    public int getNumCards() {
        return topIndex;
    }

    /**
     *
     * @return The top card, or null if the pile is empty.
     */
    public Card getTopCard() {
        if (topIndex == 0) {
            return null;
        }
        return c1[topIndex - 1];
    }

}
