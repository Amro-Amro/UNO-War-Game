package student;

public class Tournament {

    public static void main(String[] args) {

        AI randomAI = new AI();
        AI smallestAI = new AI();
        AI biggestAI = new AI();

        runMatchup(randomAI, randomAI, "Random Card AI", "Random Card AI");
        runMatchup(randomAI, smallestAI, "Random Card AI", "Smallest Card AI");
        runMatchup(randomAI, biggestAI, "Random Card AI", "Biggest Card AI");

        runMatchup(smallestAI, randomAI, "Smallest Card AI", "Random Card AI");
        runMatchup(smallestAI, smallestAI, "Smallest Card AI", "Smallest Card AI");
        runMatchup(smallestAI, biggestAI, "Smallest Card AI", "Biggest Card AI");

        runMatchup(biggestAI, randomAI, "Biggest Card AI", "Random Card AI");
        runMatchup(biggestAI, smallestAI, "Biggest Card AI", "Smallest Card AI");
        runMatchup(biggestAI, biggestAI, "Biggest Card AI", "Biggest Card AI");
    }

    private static void runMatchup(AI ai1, AI ai2, String ai1Name, String ai2Name) {
        UnoWarMatch match = new UnoWarMatch(ai1, ai2);


        double winRateAI1First = match.winRate(100);
        System.out.printf("%s vs. %s winRate: %.3f%n", ai1Name, ai2Name, winRateAI1First);


        UnoWarMatch reverseMatch = new UnoWarMatch(ai2, ai1);
        double winRateAI2First = reverseMatch.winRate(1000);
        System.out.printf("%s vs. %s winRate: %.3f%n", ai2Name, ai1Name, winRateAI2First);
    }
}

