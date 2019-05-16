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
      //generate some cards, good and bad
      Card card1 = new Card(); //tests default
      Card card2 = new Card('3', Card.Suit.hearts); //tests other constructor
      Card card3 = new Card('n', Card.Suit.diamonds); //tests invalid
      
      //print out cards
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      
      //change cards
      card1.set('P', Card.Suit.spades);
      card3.set('J',  Card.Suit.clubs);
      
      //print out cards
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());

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
      this.set(value, suit);
      
      /* From the spec: "Because we have the errorFlag member, the
       * constructor (via the mutator), can set that member when it gets bad
       * data; it does not have to assign default values upon receipt of bad
       * data
       */
      
      //Adam-I think we can leave this as the one line since we're checking 
      //isValid() inside set()
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
   //END accessors
   
   public boolean equals(Card card)
   {
      boolean isEqual = false;
      
      if (this.getValue() == card.getValue() && this.getSuit() == card.getSuit()
            && this.getErrorFlag() == card.getErrorFlag())
      {
         isEqual = true;
      }
      return isEqual;
   }
   //END accessors
   
   
   
   private boolean isValid(char value, Suit suit)
   {
      char[] validValues = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', 
                             '5', '4', '3', '2'};
      
      boolean isValid = false;
      
      for (char index : validValues)
      {
         if (Character.toUpperCase(value) == index)
         {
            isValid = true;
         }
      }
      return isValid;
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

//START class Hand
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