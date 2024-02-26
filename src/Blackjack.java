public class Blackjack {
    public static void main (String [] args) {
        Blackjack game = new Blackjack ();
        game.run ();
    }

    private void run () {
        //suits are 0-3
        //values are 2-14
        Card card1 = new Card(0,2);
        Card card2 = new Card(0,3);
        Card card3 = new Card(0,4);
        Card card4 = new Card(0,5);
        Card card5 = new Card(0,6);
        Card card6 = new Card(0,7);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        System.out.println(card4);
        System.out.println(card5);
        System.out.println(card6);


    }


}
