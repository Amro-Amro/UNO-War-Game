public class BiggestCardAI {

    @Override
    public Card getPlay(Hand hand, CardPile cardPile){

        if(hand == null || hand.getSize() == 0){
            return null;}

        Card max = null;

        for(int i = 0; i < hand.getSize(); i++) {

            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {

                if(max == null || max.getRankNum() < card.getRankNum()){
                    max = card;
                }
            }
        }

        return max;

    }


    @Override
    public String toString(){
        return "Biggest Card AI";}
}
