public class Card
{
    /************************************/
   private int deuce = 2;
   private int three = 3;
   private int four  = 4;
   private int five = 5;
   private int six = 6;
   private int seven = 7;
   private int eight = 8;
   private int nine = 9;
   private int ten = 10;
   private int ace = 11;
   /************************************/
    
    public String face;
    public String suit;
    private int value;
    
    public Card()
    {
        face = " ";
        suit = " ";
        value = 0;
    }
    public Card(String cardFace, String cardSuit, int v1)
    {
        face = cardFace;
        suit = cardSuit;
        value = v1;
    }
    public Card(String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
        value = 0;
    }
    
    public String getFace()
    {
        return face;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public int getValue()
    {
        if(face.equals("Deuce"))
            value = deuce;
        if(face.equals("three"))
            value = three;
        if(face.equals("Four"))
            value = four;
        if(face.equals("Five"))
            value = five;
        if(face.equals("Six"))
            value = six;
        if(face.equals("Seven"))
            value = seven;
        if(face.equals("Eight"))
            value = eight;
        if(face.equals("Nice"))
            value = nine;
        if(face.equals("Ten") || face.equals("Jack") || face.equals("Queen") || face.equals("King"))
            value = ten;
        if(face.equals("Ace"))
            value = ace;
            
        return value;
    }
    
    public String toString()
    {
        return face + " of " +suit;
    }
    
    public boolean equals(Card other)
    {
        if( face == other.getFace())
            if( suit == other.getSuit())
                if( value == other.getValue())
                    return true;
        return false;
    }
    public void setEquals(Card other)
    {
        face = other.getFace();
        suit = other.getSuit();
        value = other.getValue();
    }
    public void setNull()
    {
        face = " ";
        suit = " ";
        value = 0;
    }
}