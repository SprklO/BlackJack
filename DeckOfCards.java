import java.util.Random;

public class DeckOfCards
{
    private Card deck[];
    private int currentCard;
    private final int NUMBER_OF_CARDS = 52;
    private Random ranNum = new Random();
    
    public DeckOfCards()
    {
        String[] faces = {"Ace", "Deuce", "three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Dimonds", "Clubs", "Spades"};
        
        deck = new Card[NUMBER_OF_CARDS];
        for(int i = 0; i < NUMBER_OF_CARDS; i++)
            deck[i] = new Card(faces[ i % 13], suits[i /13]);
    }
    
    public void shuffle()
    {
        currentCard = 0;
        
        for (int first = 0; first < NUMBER_OF_CARDS; first++)
        {
            int second = ranNum.nextInt(NUMBER_OF_CARDS);
            
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }
    
    public Card dealCard()
    {
        if (currentCard < deck.length)
            return deck[currentCard++];
        else 
            return null;
    }
}