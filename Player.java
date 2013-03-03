import javax.swing.JOptionPane;


public class Player
{
    private String name;
    private int win;
    private int loss;
    private int cash;
    private Card[] hand;
    private int currentCard;
    private int bet;
    private int score;
    private boolean bust = false;
    private final int MAX_IN_HAND = 5;
    
    public Player()
    {
        String c = " ";
        name = JOptionPane.showInputDialog("Please enter your name: ");
        c = JOptionPane.showInputDialog("How much money are you bring to the table?: ");
        cash = Integer.parseInt(c, 10 );
        setBet(cash);

        hand = new Card[MAX_IN_HAND];
        for(int i = 0; i < hand.length; i++)
            hand[i] = new Card();
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }
    public int getWin()
    {
        return win;
    }
    public int getLoss()
    {
        return loss;
    }
    public int getCash()
    {
        return cash;
    }
    public void setCash(int amount)
    {
        cash = amount;
    }
    public int getCurrentCard()
    {
        return currentCard;
    }
    public void setCurrentCard(int card)
    {
        currentCard = card;
    }
    public int getBet()
    {
        return bet;
    }
    public void setBet(int newBet)
    {
        bet = newBet;
    }
    public int getScore()
    {
        return score;
    }
    public void setScore(int newScore)
    {
        score = newScore;
    }
    public boolean getBust()
    {
        return bust;
    }
    public void setBustTrue()
    {
        bust = true;
    }
    public void setBustFalse()
    {
        bust = false;
    }
    public String getCard(int i1)
    {
        Card myCard = hand[i1];
        return myCard.toString();
    }
    public Card getCardVal(int index)
    {
        return hand[index];
    }
    public String getCard()
    {
        Card myCard = hand[currentCard];
        return myCard.toString();
    }
    public Card[] getHand()
    {
        return hand;
    }
    public void lossCash(int loss)
    {
        cash -= loss;
    }
    public void addCash(int winnings)
    {
        cash += winnings;
    }
    public void addWin()
    {
        win++;
    }
    public void addLoss()
    {
        loss++;
    }
    public void displayStats()
    {
        JOptionPane.showMessageDialog(null, name+"\n"+ "Wins: "+ win +"\n"+"Losses: "+loss
            +"\n\n"+ currentCard +"\n" +(currentCard +1) );
    }
    
    public void addToHand(Card myCard)
    {
        if(currentCard < hand.length)
            hand[currentCard++].setEquals(myCard);
    }
    public void resetGame()
    {
        currentCard = 0;
        bet = 0;
        bust = false;
        score = 0;
        
        for(int i = 0; i < hand.length; i ++)
            hand[i].setNull();
    }
}