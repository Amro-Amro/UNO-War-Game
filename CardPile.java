public class CardPile {

    private Card[] c1;
    private int topIndex;

    public CardPile(Card topCard){
        c1 =  new Card[52];
        topIndex = 0;

        if (topCard != null) {
            c1[0] = topCard; // Set the top card
            topIndex = 1;}
        else{
            throw new IllegalArgumentException("Illegal move detected!");
        }

    }

    public boolean canPlay(Card card){
        if(card == null){
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if(topIndex == 0){
            return false;
        }

        Card topCard = c1[topIndex - 1];

        if(card.getRankNum() > topCard.getRankNum() ||
            card.getRankNum() == topCard.getRankNum() ||
            card.getSuitNum() == topCard.getSuitNum()){
            return true;}

        return false;
    }

    public void play(Card card){
        if(card == null){
            throw new IllegalArgumentException("Illegal move detected!");
        }

        if(!canPlay(card)){
            System.out.println("Illegal move detected!");
            return;
        }

        if(topIndex < c1.length){
            c1[topIndex] = card;
            topIndex ++;
        } else {
            System.out.println("Illegal move detected!");
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
