package student;

public class UnoWarMatch {

    private AI ai1;
    private AI ai2;

    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

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

                if(playingCard == null){
                    if(currentPlayer == ai1) {
                        ai2Score ++;
                        secondPlayer = ai2;
                    } else {
                        ai1Score ++;
                        secondPlayer =ai1;
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



        public double winRate ( int nTrials){
            int aiWins = 0;

            for (int i = 0; i < nTrials; i++) {
                if(playGame()){
                    aiWins ++;
                }

            }
            return (double) aiWins/nTrials;
        }

}
