
/**
 * @Author: Ribhav
 * @JavaDocs: Anuj
 */
import java.util.Scanner;
public class Player
{
    private String name; 
    private Hand hand; 
    private int chips;
    private int amountBet; 
    
    
    
    public String getName(){
        return name;
    }

    public int getAmtBet(){
        return amountBet;
    }

    public void setAmtBet(int b){
        amountBet = b;
    }

    public int subtractChips(int n){
        chips-=n;
        return chips;
    }

    Player(String n){
        name = n;
        hand = new Hand();
        chips = 100;
    }

    public void addCard(Card c){
        hand.addCard(c); 
    }

    public int getChips(){
        return chips; //returns the amount of chips the player has
    }

    public Hand getHand(){
        return hand;
    }

    public void placeBet(){
        int n = 0;
        Scanner s1 = new Scanner(System.in);
        System.out.println("How much do you want to bet? ");
        n = s1.nextInt();

        while(chips < n){
            System.out.println("Stop lying about your money!!!\nHow much do you want to bet?");
            n = s1.nextInt();
        }
        amountBet += n;
        chips -= n;
        Dealer.acceptChips(n);
    }

    public int choice(){
        int n = 0;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Do you want to hit(type 1), double down(type 2), or stand(type 3)? ");
        n = s1.nextInt();
        return n;
    }

    public void addChips(int chips){
        this.chips += chips;
    }
}

