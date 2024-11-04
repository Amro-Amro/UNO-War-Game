package student;

public class AI {


    public Card getPlay(Hand hand, CardPile cardPile){
        if(hand == null){
            return null;}

        for(int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {
                return card;
            }
        }
            return null;

    }

    public String toString(){
        return "Random Card AI";
    }
}
