import java.util.ArrayList;
public class Dealer
{
    private Hand h;
    private Shoe s;
    private ArrayList<Player> players;
    private static int pot;

    /**
     * 
     * 
     */
  
    public static void resetPot(){
        System.out.println("reseting the pot");
        pot = 0; 
    }
    
    public static void doubleDown(){
        pot*=2; //double the pot
        System.out.println("The pot has been doubled to " + pot + " chips");

    }
    public static int showPot(){
        return pot;
    }

    public static void acceptChips(int chips){
        pot += (chips*2);
        System.out.println("The pot is now " + pot + " chips");
    }
    
    public Hand getHand(){
        return h;
    }

    Dealer(ArrayList<Player> p){
         h = new Hand(); //source: Anuj
         s = new Shoe(2); 
         players = p;
    }

    public void dealCard(Player p){
        p.addCard(s.dealCard()); //add a card to that player
    }

    public String showCards(){
        return h.toString(); //get all of the dealer's cards
    }

    public Card showOneCard(){
        return h.getCards().get(0); //get one of the dealer's cards
    }


    public void start(){
        //Deal cards
        for(int i = 0; i<2; i++){ //deal two cards 
            for(int x = 1; x<=players.size(); x++){ //loop for every player, starting at player 1
                players.get(x-1).addCard(s.dealCard()); //add a card to that player
                h.addCard(s.dealCard()); //add a card to the dealers hand
            }
        }
    }


    public void turnDealer(){
        while(h.getValue() < 17){ //while the hand is less than 17
            h.addCard(s.dealCard()); //add a card to the dealers hand
        }
    }
}