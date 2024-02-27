public class Card {
    int suit;
    int value;
//
    public Card (int suit, int value) {
        this.suit = suit;
        this.value = value;

    }


    public int getSuit () {
        return suit;
    }

    public int getValue () {
        return value;
    }



    public String toString () {
        String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String [] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}   ;

        return values [this.value-2] + " " + suits [this.suit];
    }
}
