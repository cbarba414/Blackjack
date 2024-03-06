import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    private Deck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    private int playerBalance;
    private int bettingMoney;

    Scanner kb = new Scanner(System.in);


    public Blackjack() {
        deck = new Deck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        playerBalance = 50;
    }

    public static void main (String [] args) {
        Blackjack game = new Blackjack();
        game.run();
    }

    private void run() {
        // Deal initial cards
        dealInitialCards();
        placeBet();
        // Show initial hands
        System.out.println("Dealer hand:\t" + dealer.get(0) + " ?");
        System.out.println("Player hand:\t" + player.get(0) + " " + player.get(1));

        // Player's turn
        playerTurn();

        // Dealer's turn
        dealerTurn();

        // Determine the winner
        determineWinner();

        System.out.println ("Your balance: $" + playerBalance);
    }

    private void placeBet() {
        System.out.println("Your current balance: $" + playerBalance);
        System.out.println("Place your bet:");
        bettingMoney = kb.nextInt();
        while (bettingMoney <= 0 || bettingMoney > playerBalance) {
            System.out.println("Invalid bet amount. Please enter a valid bet:");
            bettingMoney = kb.nextInt();
        }
        kb.nextLine(); // Consume newline
        playerBalance -= bettingMoney;
    }

    private void dealInitialCards() {
        deck.shuffle();
        player.add(deck.getCard());
        dealer.add(deck.getCard());
        player.add(deck.getCard());
        dealer.add(deck.getCard());
    }

    private void playerTurn() {
        while (true) {
            System.out.println("\nPlayer's turn:");
            System.out.println("Player's hand:");
            printHand(player);

            int playerTotal = calculateHandValue(player);
            System.out.println("Your hand value: " + playerTotal);

            if (playerTotal >= 21) {
                break;
            }

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
        System.out.println("\nDealer's turn:");
        while (calculateHandValue(dealer) < 17) {
            dealer.add(deck.getCard());
        }
        System.out.println("Dealer's hand:");
        printHand(dealer);
    }

    private void determineWinner() {
        int playerTotal = calculateHandValue(player);
        int dealerTotal = calculateHandValue(dealer);

        System.out.println("\nPlayer's hand value: " + playerTotal);
        System.out.println("Dealer's hand value: " + dealerTotal);

        if (playerTotal > 21) {
            System.out.println("Bust! Dealer wins.");
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("Congratulations! You win!");
            playerBalance += bettingMoney;
            playerBalance += bettingMoney;
            // make it so that when you lose you don't get that money back. or maybe that's just how it oges?
        } else if (playerTotal == dealerTotal) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins!");
        }
    }

    private int calculateHandValue(ArrayList<Card> hand) {
        int totalValue = 0;
        int numAces = 0;

        for (Card card : hand) {
            int cardValue = card.getValue();
            if (cardValue == 11) {
                numAces++;
            }
            totalValue += cardValue;
        }

        while (totalValue > 21 && numAces > 0) {
            totalValue -= 10;
            numAces--;
        }

        return totalValue;
    }

    private void printHand(ArrayList<Card> hand) {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
