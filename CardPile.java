package student;

public class CardPile {

    private Card[] c1;
    private int topIndex;

    public CardPile(Card topCard){
        c1 =  new Card[52];
        topIndex = 0;
        if(topCard == null){
            return;
        }
        c1[0] = topCard; // Set the top card
        topIndex = 1;

    }

    public boolean canPlay(Card card) {
        if (card == null) {
            System.out.println("Illegal move detected!");
            return false;
        }

        if (topIndex == 0) {
            return true;
        }

        Card topCard = c1[topIndex - 1];

        return (card.getRankNum() > topCard.getRankNum() || card.getSuitNum() == topCard.getSuitNum());
    }


    public void play(Card card){
        if(card == null){
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if(!canPlay(card)){
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if(topIndex < c1.length){
            c1[topIndex] = card;
            topIndex ++;
        } else {
            return;
        }
    }

    public int getNumCards(){
        return topIndex;
    }

    public Card getTopCard(){
        if(topIndex == 0){
            return null;
        }
        return c1[topIndex - 1];
    }



}



}
