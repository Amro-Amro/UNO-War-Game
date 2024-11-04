package student;

import java.util.Random;

public class Deck{

    private Card[] deck;
    private int currentIndex = 0;

    public Deck() {

        deck = new Card[52];
        int index = 0;

        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck[index] = new Card(rank, suit);
                index++;

            }
        }

        shuffle();
}

    public void shuffle(){
        Random r = new Random();

        for (int i = deck.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public Card draw(){
        if(currentIndex >= deck.length){
            shuffle();
            currentIndex = 0;
        }

        Card nextCard = deck[currentIndex];
        currentIndex ++;
        return nextCard;

    }

    public int cardsRemaining(){
        return deck.length - currentIndex;
    }

    public boolean isEmpty(){
        if(deck.length == currentIndex){
            return true;
        }
        return false;
    }

}
