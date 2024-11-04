package student;

public class SmallestCardAI extends AI{

     @Override
     public Card getPlay(Hand hand, CardPile cardPile){

        if(hand == null || hand.getSize() == 0){
            return null;}

        Card min = null;

        for(int i = 0; i < hand.getSize(); i++) {

            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {

                if(min == null || min.getRankNum() > card.getRankNum()){
                    min = card;
                }
            }
          }

        return min;

    }

    @Override
    public String toString(){
        return "Smallest Card AI";
    }
}
