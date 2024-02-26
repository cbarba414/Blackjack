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
        return Card;
    }
}
