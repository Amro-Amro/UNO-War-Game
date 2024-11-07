package student;

/**
 * The BiggestCardAI class extends the AI class meaning it represents an
 * AI strategy that picks the highest-ranking card from the AI's hand
 * that can be legally played.
 */
public class BiggestCardAI extends AI {

    /**
     * Determines which card to play from the AI's hand, based on rank. This
     * AI picks the highest-ranking card that can be played on the card pile.
     *
     * @param hand The current hand of the AI.
     * @param cardPile The current state of the card pile.
     * @return The highest-ranking playable card from the hand, or null if no card can be played.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {

        if (hand == null || hand.getSize() == 0) {
            return null; 
        }

        Card max = null;

        for (int i = 0; i < hand.getSize(); i++) {

            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {

                if (max == null || max.getRankNum() < card.getRankNum()) {
                    max = card;
                }
            }
        }

        return max;

    }

    /**
     *
     * @return A string representing this AI as "Biggest Card AI".
     */
    @Override
    public String toString() {
        return "Biggest Card AI"; }
}
