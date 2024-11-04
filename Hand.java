package student;

public class Hand {

    private Card[] hand;
    private int i;
    private Deck deck;

    public Hand(Deck deck, int size){
        this.deck = deck;
        hand = new Card[size];

        for(i = 0; i < size; i++){
            hand[i] = deck.draw();
        }
    }

    public int getSize(){
        return hand.length;
    }

    public Card get(int i){
        if(i >= hand.length || i < 0){
            System.out.println("Invalid hand index!");
            return hand[0];
        } else {return hand[i];}
    }

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

    public void refill() {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = deck.draw();
            }
        }
    }
}
