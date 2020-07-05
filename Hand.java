import java.util.ArrayList;
public class Hand
{
    foo
    private ArrayList<Card> cards;
    private int value;
    public Hand(){  // Creates an arrayList to store the hand in 
        cards = new ArrayList<Card>();
        value = 0;
    }

    /**
     *Adds a card to the hand(Deals a card)
     * @param - Card c 
     * @return - void
     *
     */
    public void addCard(Card c){
        cards.add(c);
    }

    /**
     * Returns the value of the hand
     * @param - none 
     * @return - int
     *
     */
    public int getValue(){
        value = 0;
        for(int k = 0; k < cards.size(); k++){ // Runs through the Deck ArrayList
            value += cards.get(k).getCardValue(); 
        }
        return value;
    }

    /**
     * Returns the cards in the hand
     * @param - none 
     * @return - integer; cards in the hand
     *
     */
    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * Checks if the the player has a blackjack, bust, or neither
     * @param - none 
     * @return - int
     *
     */
    public int check()
    {
        if(value == 21){ //if blackjack
            return 0;
        }
        if(value > 21){ //if bust
            return 1;
        }
        return 2; //less than 21
    }

    public String toString()
    {
        String i = "";
        for(int k = 0; k < cards.size(); k ++){
            i += cards.get(k).toString() + "\n";
        }
        return i;
    }

    /**
     * Clears the Arraylist
     * @param - none 
     * @return - void
     *
     */
    public void resetHand(){ // Clears the Arraylist
        for (int k = cards.size()-1; k >= 0; k--){
            cards.remove(k);
        }
    }
}
