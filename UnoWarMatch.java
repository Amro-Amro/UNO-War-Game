package student;

/**
 * The UnoWarMatch class simulates a match between two AI players in a simplified card game.
 * The game is played in rounds, where each AI tries to play cards, and the first to reach
 * a score of 10 wins the match.
 */
public class UnoWarMatch {

    /**
    * This makes AI (1).
    */
    private AI ai1;

    /**
    * This makes another AI (2).
    */
    private AI ai2;

    /**
     * This constructor creates an UnoWarMatch with two AI players.
     *
     * @param ai1 The first AI player.
     * @param ai2 The second AI player.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * This simulates a full game between the two AI players. The game is played until
     * one AI scores 10 points, and the AI that scores 10 points first is declared the winner.
     * The game involves alternating turns between the two AIs, playing cards from their hands,
     * and scoring based on whether a valid card can be played.
     *
     * @return true if AI1 wins the game by scoring 10 points, false if AI2 wins.
     */
    public boolean playGame() {
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);

        int ai1Score = 0;
        int ai2Score = 0;
        AI currentPlayer = ai1;
        AI secondPlayer = ai2;

        boolean roundOver = false;

        while (ai1Score < 10 && ai2Score < 10) {
            CardPile cardPile = new CardPile(null);
            roundOver = false;

            if (hand1.getSize() == 0 || hand2.getSize() == 0) {
                hand1 = new Hand(deck, 5);
                hand2 = new Hand(deck, 5);
            }

            while (!roundOver) {
                Hand currentHand = (currentPlayer == ai1) ? hand1 : hand2;
                Card playingCard = currentPlayer.getPlay(currentHand, cardPile);

                if (playingCard == null) {
                    if (currentPlayer == ai1) {
                        ai2Score++;
                        secondPlayer = ai2;
                    } else {
                        ai1Score++;
                        secondPlayer = ai1;
                    }
                    roundOver = true;

                    } else {

                    cardPile.play(playingCard);
                    currentHand.remove(playingCard);

                    if (currentHand.getSize() == 0) {
                        roundOver = true;
                    } else {
                        // Switch players
                        AI temp = currentPlayer;
                        currentPlayer = secondPlayer;
                        secondPlayer = temp;
                    }
                }
            }
        }
                return ai1Score == 10;


    }

    /**
     * Plays multiple games between the two AI players and calculates the win rate.
     *
     * @param nTrials The number of games to simulate.
     * @return The win rate of AI1 as a percentage between 0.0 and 1.0.
     */
     public double winRate(int nTrials) {
         int aiWins = 0;

         for (int i = 0; i < nTrials; i++) {
             if (playGame()) {
                 aiWins++;
             }

         }
         return (double) aiWins / nTrials;
     }

}
