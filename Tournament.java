package student;

/**
 * The Tournament class simulates a series of matches between different AI players
 * in the UnoWar card game. It runs multiple trials of the game for each pair of AI,
 * and calculates their win rates, and prints the results.
 */
public class Tournament {

    /**
     * The main method runs the tournament between different AI strategies by
     * simulating matches with 1000 trials each, printing the win rate of each match.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        AI randomAI = new AI();
        AI smallestAI = new SmallestCardAI();
        AI biggestAI = new BiggestCardAI();

        int nTrials = 1000;

        UnoWarMatch match1 = new UnoWarMatch(randomAI, randomAI);
        UnoWarMatch match2 = new UnoWarMatch(randomAI, smallestAI);
        UnoWarMatch match3 = new UnoWarMatch(randomAI, biggestAI);
        UnoWarMatch match4 = new UnoWarMatch(smallestAI, randomAI);
        UnoWarMatch match5 = new UnoWarMatch(smallestAI, smallestAI);
        UnoWarMatch match6 = new UnoWarMatch(smallestAI, biggestAI);
        UnoWarMatch match7 = new UnoWarMatch(biggestAI, randomAI);
        UnoWarMatch match8 = new UnoWarMatch(biggestAI, smallestAI);
        UnoWarMatch match9 = new UnoWarMatch(biggestAI, biggestAI);


        System.out.printf("Random Card AI vs. Random Card AI winRate: %.3f\n", match1.winRate(nTrials));
        System.out.printf("Random Card AI vs. Smallest Card AI winRate: %.3f\n", match2.winRate(nTrials));
        System.out.printf("Random Card AI vs. Biggest Card AI winRate: %.3f\n", match3.winRate(nTrials));
        System.out.printf("Smallest Card AI vs. Random Card AI winRate: %.3f\n", match4.winRate(nTrials));
        System.out.printf("Smallest Card AI vs. Smallest Card AI winRate: %.3f\n", match5.winRate(nTrials));
        System.out.printf("Smallest Card AI vs. Biggest Card AI winRate: %.3f\n", match6.winRate(nTrials));
        System.out.printf("Biggest Card AI vs. Random Card AI winRate: %.3f\n", match7.winRate(nTrials));
        System.out.printf("Biggest Card AI vs. Smallest Card AI winRate: %.3f\n", match8.winRate(nTrials));
        System.out.printf("Biggest Card AI vs. Biggest Card AI winRate: %.3f\n", match9.winRate(nTrials));
    }
}

