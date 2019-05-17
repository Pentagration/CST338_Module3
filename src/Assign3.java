import java.util.Arrays;

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
      //testing Card class
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

      //test equals
      System.out.println(card1.equals(card1));
      System.out.println(card1.equals(card2));
      
      //testing Hand class
      //create Cards and one Hand
      Card hCard1 = new Card();
      Card hCard2 = new Card('a', Card.Suit.clubs);
      Card hCard3 = new Card('a', Card.Suit.hearts);
      Card hCard4 = new Card('a', Card.Suit.diamonds);
      Card hCard5 = new Card('t', Card.Suit.clubs);
      Hand hand1 = new Hand();
      
      //use a loop to populate Hand with Cards
      for (int i = 0; i < Hand.MAX_CARDS; i++)
      {
         if (i % 5 == 0) 
         {
            hand1.takeCard(hCard5);
         }
         else if (i % 5 == 1)
         {
            hand1.takeCard(hCard4);
         }
         else if (i % 5 == 2)
         {
            hand1.takeCard(hCard3);
         }
         else if (i % 5 == 3)
         {
            hand1.takeCard(hCard2);
         }
         else
         {
            hand1.takeCard(hCard1);
         }
      }
      
      //display hand using toString()
      System.out.println(hand1.toString());
      
      //test inspectCard good
      System.out.println(hand1.inspectCard(1).toString());
      
      //play each card from Hand using a loop and display
      while (hand1.getNumCards() > 0)
      {
         System.out.println("Playing " + hand1.playCard().toString());
      }
      
      //test inspectCard bad

      System.out.println(hand1.inspectCard(1).toString());
      
      //display now empty Hand
      System.out.println(hand1.toString());
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
   
   
   /**
    * There is a default Card constructor Card() that sets the card to
    * 'A', Suit.spades.  
    * 
    * There is a constructor Card(char value, Suit suit) that sets the card
    * according to the parameters.  
    * 
    * @param value = 'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4',
    * '3', '2'
    * 
    * suit = clubs, diamonds, hearts, spades
    */
   
   //Default constructor
   public Card()
   {
      this.set('A', Suit.spades);
   }
   
   //Constructor
   public Card(char value, Suit suit)
   {
      this.set(value, suit);
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
   
   
   /**
    * There are three accessors in the Card class getSuit(), getValue(), and 
    * getErrorFlag().
    */
   
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
   public static final int MAX_CARDS = 52;
   
   private Card[] myCards;
   private int numCards;
   
   //Default constructor
   public Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   
   public void resetHand()
   {
      this.numCards = 0;
   }
   
   public boolean takeCard(Card card)
   {
      boolean newCard = false;
      
      if (numCards + 1 <= MAX_CARDS)
      {
         myCards[numCards] = new Card(card.getValue(), card.getSuit());
         this.numCards++;
         newCard = true;
      }
      
      return newCard;
   }
   
   public Card playCard()
   {
      Card play = myCards[numCards-1];
      myCards[numCards-1] = null;
      this.numCards--;
      return play; 
   }
   
   public String toString()
   {
      StringBuilder sb = new StringBuilder("Hand = ( ");
      if (this.numCards > 0)
         {
         for (Card card:myCards)
            {
            sb.append(card.toString() + ", ");
            //sb.append(card.getValue() + "of" + card.getSuit());
            //I think the above is a little easier.  I'm not sure
            //how to best limit.  Could do a counter and if counter % 5 = 0
            //then insert a /n character maybe?
            }
         }
      sb.append(" )");
      return sb.toString();
   }
   
   public int getNumCards()
   {
      return this.numCards;
   }
   
   public Card inspectCard(int k)
   //shoud we add a check to see if the int k is out of bounds of the array
   //before going into the check below?
   {
      if (this.myCards[k] != null)
      {
         return this.myCards[k];
      }
      else
      {
         Card tempCard = new Card('z', Card.Suit.clubs);
         return tempCard;
      }
   }
}
//END class Hand

//START class Deck
class Deck
{
   public static final int MAX_CARDS = 6 * 52;
   private static Card[] masterPack = new Card[52];
   Card[] cards;
   int topCard;

   public Deck()
   {

   }

   public Deck(int numPacks)
   {

   }

   public void init(int numPacks)
   {

   }

   public void shuffle()
   {

   }

   public Card dealCard()
   {

   }

   public Card inspectCard(int k)
   {

   }

   private static void allocateMasterPack()
   {
      char[] value = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4',
     '3', '2'};
      for (int i = 0, j=0; i < value.length;i++)
      {
         Card card1 = new Card(value[i], Card.Suit.clubs);
         masterPack[j++] = card1;
         Card card2 = new Card(value[i], Card.Suit.spades);
         masterPack[j++] = card2;
         Card card3 = new Card(value[i], Card.Suit.hearts);
         masterPack[j++] = card3;
         Card card4 = new Card(value[i], Card.Suit.diamonds);
         masterPack[j++] = card4;
      }
   }
}