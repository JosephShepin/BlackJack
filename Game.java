import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args){
        ArrayList<Player> players = new ArrayList();
        players.add(new Player("Furry Nathanieshot"));
        Dealer d = new Dealer(players);
        boolean playGame = true;
        while(playGame){

            d.getHand().resetHand();
            players.get(0).getHand().resetHand();

            System.out.println("You have " + players.get(0).getChips() + " chips");

            d.start();

            System.out.println("\n***Dealer's Card***");
            System.out.println(d.showOneCard());

            System.out.println("\n***Your Cards***");
            System.out.println(players.get(0).getHand());

            players.get(0).placeBet();

            System.out.println("\n***Dealer's 2 Cards***");
            System.out.println(d.showCards());

            int choice = players.get(0).choice(); //this stores the users input
            boolean askAgain = false;

            while(choice == 2 && players.get(0).getChips() < players.get(0).getAmtBet() * 2){
                System.out.println("Your out of money, pick another choice");
                choice = players.get(0).choice(); //this stores the users input
            }

            if(choice == 1){ //if hit
                d.dealCard(players.get(0));
                askAgain = true;
            }else if(choice == 2){ //double down
                System.out.println("Your balance is now " + players.get(0).subtractChips(players.get(0).getAmtBet() * 2));
                Dealer.acceptChips(players.get(0).getAmtBet() * 2);
                players.get(0).setAmtBet(players.get(0).getAmtBet() * 2);
                askAgain = true;
                d.dealCard(players.get(0)); //deal another card to the player
            }

            while(players.get(0).getHand().getValue() < 21 && askAgain){
                System.out.println("\n***Your Cards***");
                System.out.println(players.get(0).getHand());
                choice = players.get(0).choice(); //this stores the users input

                while(choice == 2 && players.get(0).getChips() < players.get(0).getAmtBet() * 2){
                    System.out.println("Your out of money, pick another choice");
                    choice = players.get(0).choice(); //this stores the users input
                }

                if(choice == 1){ //if hit
                    d.dealCard(players.get(0));
                }else if(choice == 2){ //double down
                    System.out.println("Your balance is now " + players.get(0).subtractChips(players.get(0).getAmtBet() * 2));
                    Dealer.acceptChips(players.get(0).getAmtBet() * 2);
                    d.dealCard(players.get(0)); //deal another card to the player

                }else{
                    askAgain = false;
                }
            }

            d.turnDealer();
            System.out.println("\n***Dealer's Cards***");
            System.out.println(d.showCards());

            int playerResult = players.get(0).getHand().check();
            int dealerResult = d.getHand().check();

            System.out.println("\n***Your Cards***");
            System.out.println(players.get(0).getHand());

            if(playerResult == 0 && dealerResult != 0){ //if player has blackjack and dealer does not
                System.out.println("Player wins!"); 
                players.get(0).addChips(Dealer.showPot()); //adds the pot amount to to player's chip amount
            }
            else if(playerResult != 0 && dealerResult == 0){ //if player does not hsve a blackjack but dealer does
                System.out.println("Dealer wins!");
            }
            else if(playerResult == 0 && dealerResult == 0){
                System.out.println("Draw!");
                players.get(0).addChips((Dealer.showPot())/ 2); //adds the pot amount to to player's chip amount
            }
            else if(playerResult == 2 && dealerResult == 2){
                if(players.get(0).getHand().getValue() > d.getHand().getValue()){ //checks if player hand value is more than dealer hand value if no bust or blackjack for both
                    System.out.println("Player wins!");
                    players.get(0).addChips(Dealer.showPot());
                }
                else if(d.getHand().getValue() > players.get(0).getHand().getValue()){ //checks if dealer won and no bust or blackjack
                    System.out.println("Dealer wins!");
                }else{
                    System.out.println("Nobody Wins");
                    players.get(0).addChips((Dealer.showPot())/ 2);
                }
            }
            else{
                System.out.println("Nobody Wins");
                players.get(0).addChips((Dealer.showPot())/ 2); //adds the pot amount to to player's chip amount
            }
            System.out.println("Your have " + players.get(0).getChips() + " chips");
            players.get(0).setAmtBet(0);
            Dealer.resetPot();

            String n;
            Scanner s1 = new Scanner(System.in);
            System.out.println("Play again Yes/No? ");
            n = s1.nextLine();
            if(n.toLowerCase().equals("yes")){
                playGame = true;
            }else{
                playGame = false;
            }
        }
    }
}
