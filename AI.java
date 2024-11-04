package student;

public abstract class AI {

     public Card getPlay(Hand hand, CardPile cardPile) {
        if(hand == null || hand.getSize() == 0){
            return null;}

        for(int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {

                return card;
            }
        }
            return null;

    }

    @Override
    public String toString(){
        return "Random Card AI";
    }
}
