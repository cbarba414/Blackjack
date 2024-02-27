import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

   private Deck deck;
   private ArrayList<Card> player;
   private ArrayList<Card> dealer;

   Scanner kb = new Scanner(System.in);


   public Blackjack() {
       deck = new Deck ();
       player = new ArrayList<>();
       dealer = new ArrayList<>();
   }

    public static void main (String [] args) {
        Blackjack game = new Blackjack ();
        game.run ();
    }

    private void run () {
        //suits are 0-3
        //values are 2-14
        deck.shuffle();

        player.add(deck.getCard());
        dealer.add(deck.getCard());
        player.add(deck.getCard());
        dealer.add(deck.getCard());

        System.out.println ("dealer hand:\t" + dealer.get(0) + "?");
        System.out.println ("player hand:\t" + dealer.get(0) + " " + dealer.get(1));

//        for (int i = 0; i < player.size(); i++) {
//            player.get(i);
//        } not complete satamemetn
        //i could print?

        System.out.println();
        System.out.println("hit or stay? [h/s]");

        String response= kb.nextLine();
        if (response.equals ("hit")) {
            player.add (deck.getCard());
            //while 9response.equals hit
            //do (somtheitng) while (laksndlas);
        }

    }

    //deal cards
  //  player turn
    //dealer turn
    ///calc hand value


}
