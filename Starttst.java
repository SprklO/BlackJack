public class Starttst
{
    public static void main(String[] args)
    {
        StartOfJack bJack = new StartOfJack();
        //Player p1 = new Player();
        Card myCard;
        DeckOfCards deck = new DeckOfCards();
        
        deck.shuffle();
        
        bJack.playGame();
       
        
    }
}