package student;

/** Name: Amro Abuatieh
 * Class: CSCI 1913
 *
 * The Card class represents a single playing card in a standard deck.
 * Each card has a rank and a suit, both being integers.
 * The rank is an integer between 1 and 13 (1 = Ace, 11 = Jack, 12 = Queen, 13 = King).
 * The suit is an integer between 1 and 4 (1 = Spades, 2 = Hearts, 3 = Clubs, 4 = Diamonds).
 * This class overrides the toString and equals method.
 */
public class Card {

    private int rank;
    private int suit;

    /**
     * With the given rank and suit, a new card is made.
     * If the rank or suit is invalid, the card will default to Ace of Spades.
     *
     * @param rank the rank of the card 1 for Ace, 2 for Two, ..., 11 for Jack, 12 for Queen, 13 for King
     * @param suit the suit of the card 1 for Spades, 2 for Hearts, 3 for Clubs, 4 for Diamonds
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }

    }

    /**
     *
     * @return the rank of the card as an integer for example 1 = Ace, and 2 = Two
     */
    public int getRankNum() {
        return rank;
    }

    /**
     *
     * @return the suit of the card as an integer for example 1 = spades
     */
    public int getSuitNum(){
        return suit;
    }

    /**
     *
     * @return the name of the card's rank as a string For example, Ace for 1
     */
    public String getRankName() {
        switch (rank) {
            case 1:
                return "Ace";

            case 2:
                return "Two";

            case 3:
                return "Three";

            case 4:
                return "Four";

            case 5:
                return "Five";

            case 6:
                return "Six";

            case 7:
                return "Seven";

            case 8:
                return "Eight";

            case 9:
                return "Nine";

            case 10:
                return "Ten";

            case 11:
                return "Jack";

            case 12:
                return "Queen";

            case 13:
                return "King";

            default:
                return "Invalid Card";
        }
    }

    /**
     *
     * @return the name of the card's suit as a string, for example Spades for 1
     */
    public String getSuitName() {
        switch (suit) {
            case 1:
                return "Spades";

            case 2:
                return "Hearts";

            case 3:
                return "Clubs";

            case 4:
                return "Diamonds";

            default:
                return "Invalid Card";
        }
    }

    /**
     *
     * @return a string representing the card, Ex: Ace of Spades
     */
    @Override
    public String toString(){

        String cardRank = getRankName();
        String cardSuit = getSuitName();

        return cardRank + " of " + cardSuit;}

    /**
     *
     * @param other the object that compares two cards or objects together.
     * @return true if the given object represents a Card with the same rank and suit, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof Card) {
            Card otherCard = (Card) other;
            return this.rank == otherCard.rank
                && this.suit == otherCard.suit;

        } else{
            return false;
        }
    }

}
