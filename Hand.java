public class Hand {

    private Card[] hand;
    private int i;
    private Deck deck;

    public Hand(Deck deck, int size){
        hand = new Card[size];

        for(i = 0; i < size; i++){
            hand[i] = deck.draw();
        }
    }

    public int getSize(){
        return hand.length;
    }

    public Card get(int i){
        if(i > hand.length){
            System.out.print("Your value " + i + " is out of bounds!!");
            return hand[0];
        }
        return hand[i];
    }

    public boolean remove(Card card){
        if(card == null){
            return false;
        }
        for(int j = 0; j < hand.length; j++){
            if(hand[j].equals(card)){
                hand[j] = deck.draw();
                return true;
            }
        }
        return false;
    }

}
