package student;

/**
 * The AI class represents a basic AI for a card game.
 * It chooses the first playable card from the hand that can be played
 * according to the rules of the game. If no card can be played, it returns null.
 */
public class AI {

    /**
     * Determines which card to play from the AI's hand.
     * The AI selects the first card that can be played on the given card pile
     * based on the game's rules.
     *
     * @param hand The current hand of the AI.
     * @param cardPile The current state of the card pile.
     * @return The first playable card from the hand, or null if no card can be played.
     */
     public Card getPlay(Hand hand, CardPile cardPile) {
        if (hand == null || hand.getSize() == 0) {
            return null; 
        }

        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {

                return card;
            }
        }
            return null;

    }

    /**
     *
     * @return A string representing the AI as "Random Card AI".
     */
    @Override
    public String toString() {
         return "Random Card AI";
}
}     
