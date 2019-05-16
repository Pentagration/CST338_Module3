/*
 * STUDENTS: Jason Pettit, Sergio Quiroz, Marcus Gonzalez, 
 *           Adam Houser, Colin Reed
 * COURSE: CST 338-30_SU19
 * EXERCISE: Module 3 Deck of Cards
 */

public class Assign3
{

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub

   }

}

//START class Card
class Card
{
   public enum Suit
   {
      clubs, diamonds, hearts, spades;
   }
   
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   //Default constructor
   public Card()
   {
      this.set('A', Suit.spades);
   }
   
   //Constructor
   public Card(char value, Suit suit)
   {
      if(errorFlag == false)
      {
         this.set(value, suit);  
      }
      else
      {
         /* From the spec: "Because we have the errorFlag member, the
          * constructor (via the mutator), can set that member when it gets bad
          * data; it does not have to assign default values upon receipt of bad
          * data
          */
      }

   }
   
   //START mutators
   public boolean set(char value, Suit suit)
   {
      if(isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         this.errorFlag = false;
      }
      else
      {
         this.errorFlag = true;
      }
      
      return this.errorFlag;
   }
   //END mutators
   
   //START accessors
   public Suit getSuit()
   {
      return this.suit;
   }
   
   public char getValue()
   {
      return this.value;
   }
   
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   public boolean equals(Card card)
   {
      if (this.getValue() == card.getValue() && this.getSuit() == card.getSuit()
            && this.getErrorFlag() == card.getErrorFlag())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   //END accessors
   
   
   
   private boolean isValid(char value, Suit suit)
   {
      char[] validValues = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', 
                             '5', '4', '3', '2'};
      
      for (char index : validValues)
      {
         if (Character.toUpperCase(value) == index)
         {
            return true;
         }
         else
         {
            return false;
         }
      }
   }
   
   /** 
    * toString() concatenates the A thru 2 card value and the card suit into a
    * single string "value of suit" example: "A of clubs"
    * 
    * @param none
    * @return Returns a string
    */
   public String toString()
   {
      if(errorFlag == true)
      {
         return "[invalid]";
      }
      else
      {
      String card = value + " of " + suit;
      return card;
      }
    } 
}
//END class Card

//START class Card
class Hand
{
   public int MAX_CARDS = 100;
   
   private Card[] myCards;
   private int numCards;
   
   //Default constructor
   public Hand()
   {
      
   }
   
   public void resetHand()
   {
      
   }
}