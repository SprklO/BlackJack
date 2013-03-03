 import javax.swing.JOptionPane;

//pg261


public class StartOfJack
{

   
    private int numOfPlayers;
    private DeckOfCards myDeckCards;
    private Player[] playerArray;
    private int[] playerScore;
    
    public StartOfJack()
    {
        String numPlay;
        
        myDeckCards = new DeckOfCards();
        
        numPlay = JOptionPane.showInputDialog("How many people will be playing?: ");
        numOfPlayers = Integer.parseInt(numPlay, 10 );
        playerArray = new Player [numOfPlayers];
        playerScore = new int [numOfPlayers];
        
        for(int i = 0; i < numOfPlayers; i++)
            playerArray[i] = new Player();
    }
    
    public void addScore(Player p1)
    {
        int score = 0;
            for(int k = 0; k < p1.getHand().length; k++)
            {
                score += p1.getCardVal(k).getValue();
            }
            p1.setScore(score);
    }
    
    public boolean isBust(int myScore)
    {
        if(myScore > 21)
            return true;
        else
            return false;
    }
   
    public void playHand()
    {   
        Card newCard;
        myDeckCards.shuffle();
       
        for (int i = 0; i< playerArray.length; i++)
        {
            for(int k = 0; k < 2; k++)
            {
                newCard = myDeckCards.dealCard();
                playerArray[i].addToHand(newCard);
            }
            addScore(playerArray[i]);
        }
        displayPlayer();
    }
    
    public void displayDeck()
    {
        myDeckCards.shuffle();
        for (int i = 0; i < 52; i++)
        {
            System.out.printf("%-19s", myDeckCards.dealCard());
            
            if(i% 4 == 0)
                System.out.println();
        }
    }
    
    public void displayPlayer()
    {
        Card myCard;
        String s1;
        for(int i = 0; i < playerArray.length; i++)
        {
            s1 = "";
            for(int k = 0; k < playerArray[i].getCurrentCard(); k++)
            {
                s1 += playerArray[i].getCard(k) + "\n";
            }
            JOptionPane.showMessageDialog(null,playerArray[i].getName() + "\n"  + s1 + "\n\n"+ "Bet: $"
                + playerArray[i].getCash() + "\n\nTotal Score: "+ playerArray[i].getScore());
        }
            
    }
    
    public void displayPlayer(Player p1)
    {
       String s1 = "";
       
            for(int k = 0; k < p1.getCurrentCard(); k++)
            {
                s1 += p1.getCard(k) + "\n";
            }
            JOptionPane.showMessageDialog(null,p1.getName() + "\n"+ s1 + "\n\n"+ "Bet: $"
                + p1.getCash() + "\n\nTotal Score: "+ p1.getScore());
     }
    
    public void hitOrStay(Player p1)
    {
        Card newCard;
        String in1;
        char cont;
        in1 = JOptionPane.showInputDialog( p1.getName() +", would you like to hit (h) or stay (s)?\n"
                + "your current score is " + p1.getScore());
        cont = Character.toLowerCase(in1.charAt(0));
        
        while (cont == 'h')
        {
               newCard = myDeckCards.dealCard();
               p1.addToHand(newCard);
               addScore(p1);
               if(isBust(p1.getScore()))
               {
                  JOptionPane.showMessageDialog(null,"its a bust! :( " + p1.getName() +" losses\n"
                        + p1.getName() + "'s score was: " + p1.getScore());
                  p1.setScore(0);
                  cont = 's';
               }
               else
               {
                  displayPlayer(p1);   
                  in1 = JOptionPane.showInputDialog(p1.getName() +", would you like to hit (h) or stay (s)?\n"
                        + "your current score is " + p1.getScore());
                  cont = Character.toLowerCase(in1.charAt(0));
               }
        }
    }
    
    public void whoWins()
    {
       
        int i = 0;
        int index = 0;
        int largest =0;
        int pot = 0;
       
        for(i = 0; i < playerArray.length; i++)
        {
            pot += playerArray[i].getCash();
            if(playerArray[i].getScore() > largest)
            {
                largest = playerArray[i].getScore();
                index = i;
            }
            else if( playerArray[i].getScore() == 0 || playerArray[i].getScore() < largest)
                playerArray[i].addLoss();
        }
        playerArray[index].setCash(pot);
        playerArray[index].addWin();
        JOptionPane.showMessageDialog(null, playerArray[index].getName() +" Wins $" + playerArray[index].getCash() +" \nWith a score of " + 
            playerArray[index].getScore());
    }
    public void playGame()
    {
        playHand();
        for(int i = 0; i < playerArray.length; i++)
            hitOrStay(playerArray[i]);
        displayPlayer();
        whoWins();
    }
}