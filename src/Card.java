public class Card {
    int value;
    int suit;

    public Card (int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue () {
        return value;
    }


    public int getSuit () {
        return suit;
    }

    public String toString () {
        String [] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}   ;
        String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return values [this.value-2] + " " + suits [this.suit];
    }
}
