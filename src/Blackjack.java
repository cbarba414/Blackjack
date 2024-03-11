import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
// this class runs the game
    private Deck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    private int playerBalance;
    private int bettingMoney;

    Scanner kb = new Scanner(System.in);


    public Blackjack() {
        // creates deck, player and dealer card hands, and sets the player money to 50
        deck = new Deck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        playerBalance = 50;
    }

    public static void main (String [] args) {
        // runs game
        Blackjack game = new Blackjack();
        game.run();
    }

    private void run() {
        dealInitialCards();
        placeBet();
        // display initial hands
        System.out.println("Dealer hand:\t" + dealer.get(0) + " ?");
        System.out.println("Player hand:\t" + player.get(0) + " " + player.get(1));

        playerTurn();
        dealerTurn();
        determineWinner();

        System.out.println ("Your balance: $" + playerBalance);
    }

    private void placeBet() {
        // allows player to place bet, takes scanner input to determine what gets taken out of their money
        System.out.println("Your current balance: $" + playerBalance);
        System.out.println("Place your bet (1-50):");
        bettingMoney = kb.nextInt();
        while (bettingMoney <= 0 || bettingMoney > playerBalance) {
            System.out.println("Invalid bet amount. Please enter a value between $1 and $50.");
            bettingMoney = kb.nextInt();
        }
        kb.nextLine();
        playerBalance -= bettingMoney;
    }

    private void dealInitialCards() {
        // shuffles deck in deck class
        // deals 2 cards each to dealer and player
        deck.shuffle();
        player.add(deck.getCard());
        dealer.add(deck.getCard());
        player.add(deck.getCard());
        dealer.add(deck.getCard());
    }

    private void playerTurn() {
        // shows the player hand
        while (true) {
            System.out.println("\nPlayer's turn:");
            System.out.println("Player's hand:");
            printHand(player);

            int playerTotal = calculateHandValue(player);
            System.out.println("Your hand value: " + playerTotal);

            if (playerTotal >= 21) {
                break;
            }
            // allows player to hit or stay
            // if s is entered, the player will stay with their hand value while dealer picks cards
            // if h is entered, the player will grab a card
            System.out.println("Hit or stay? [h/s]");
            String response = kb.nextLine();
            if (response.equalsIgnoreCase("h")) {
                player.add(deck.getCard());
            } else if (response.equalsIgnoreCase("s")) {
                break;
            }


        }
    }

    private void dealerTurn() {
        // dealer will grab card if their hand value is under 17
        // and itll be printed
        System.out.println("\nDealer's turn:");
        while (calculateHandValue(dealer) < 17) {
            dealer.add(deck.getCard());
        }
        System.out.println("Dealer's hand:");
        printHand(dealer);
    }

    private void determineWinner() {
        // prints out hand values of player and dealer
        int playerTotal = calculateHandValue(player);
        int dealerTotal = calculateHandValue(dealer);

        System.out.println("\nPlayer's hand value: " + playerTotal);
        System.out.println("Dealer's hand value: " + dealerTotal);

        // determines winner based on hand values
        if (playerTotal > 21) {
            // if card value is over 21 after hitting
            System.out.println("Bust! Dealer wins. :(");
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            // if player´s hand value stays under 21
            // or has a total over the dealer's
            System.out.println("Congratulations! You win! :D");
            playerBalance += bettingMoney;
            playerBalance += bettingMoney;
            // gets DOUBLE! their original money back if won
        } else if (playerTotal == dealerTotal) {
            // if value of cards is tied, itll print this
            System.out.println("It's a tie! :/");
            // will give player betting money back
            playerBalance += bettingMoney;
        } else {
            System.out.println("Dealer wins! :(");
        }
    }

    private int calculateHandValue(ArrayList<Card> hand) {
        int totalValue = 0;
        int numAces = 0;

        // for loop that determines ace values
        // will set ace to 11
        for (Card card : hand) {
            int cardValue = card.getValue();
            if (cardValue == 11) {
                numAces++;
            }
            totalValue += cardValue;
        }

        // will set ace to 1
        while (totalValue > 21 && numAces > 0) {
            totalValue -= 10;
            numAces--;
        }

        return totalValue;
    }

    private void printHand(ArrayList<Card> hand) {
        // prints the card hands
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
