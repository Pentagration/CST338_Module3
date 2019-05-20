/*
 * STUDENTS: Jason Pettit, Sergio Quiroz, Marcus Gonzalez, 
 *           Adam Houser, Colin Reed
 * COURSE: CST 338-30_SU19
 * EXERCISE: Module 3 Deck of Cards
 */

import java.util.Random;
import java.util.Scanner;

public class Assign3
{

   static Scanner keyboard = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      //START TESTS************************************************************
      //INSTRUCTIONS SAY ONLY TURN IN OUTPUT FROM PHASE 3 AND 4
      //COMMENTING OUT PHASE 1 AND 2 TESTS
      /*
      //PHASE 1: testing Card class
      //generate some cards, good and bad
      System.out.println("Create default A-spades, 3-hearts, and n-diamonds:");
      Card card1 = new Card(); //tests default
      Card card2 = new Card('3', Card.Suit.hearts); //tests other constructor
      Card card3 = new Card('n', Card.Suit.diamonds); //tests invalid
      
      //print out cards
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      System.out.println(); //blank line
      
      //change cards
      card1.set('P', Card.Suit.spades);
      card3.set('J',  Card.Suit.clubs);
      
      //print out cards
      System.out.println("Use card.set to change cards P-spades and J-clubs:");
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      System.out.println(); //blank line

      //test equals
      System.out.println("Test card.equals card1 = card1 and card1 = card2:");
      System.out.println(card1.equals(card1));
      System.out.println(card1.equals(card2));
      System.out.println(); //blank line
      
      //PHASE 2: testing Hand class
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
         if (i % 5 == 0) //%5 is for formatting the output
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
      System.out.println("Display the hand:");
      System.out.println(hand1.toString());
      System.out.println(); //blank line;

      
      //test inspectCard good
      System.out.println("Test hand.inspectCard(1):");
      System.out.println(hand1.inspectCard(1).toString());
      System.out.println(); //blank line
      
      
      //play each card from Hand using a loop and display
      System.out.println("Test hand.playCard():");
      while (hand1.getNumCards() > 0)
      {
         System.out.println("Playing " + hand1.playCard().toString());
      }
      System.out.println(); //blank line

      //display now empty Hand
      System.out.println("Display the empty hand:");
      System.out.println(hand1.toString());
      System.out.println();
      
      //test inspectCard bad
      System.out.println("Test hand.inspectCard() with illegal argument:");
      System.out.println(hand1.inspectCard(1).toString());
      System.out.println(); //blank line
      */
      
      //PHASE 3: test Deck class 
      //test Deck class with two decks
      System.out.println("Display two decks, unshuffled:");
      Deck deck = new Deck(2);
      for (int i = deck.getTopCard(), cardCount = 0; i >= 0;i--, cardCount++)
      {
         System.out.print(deck.dealCard().toString() + " / ");
         if (cardCount == 5)
         {
            System.out.print("\n");
            cardCount = 0;
         }
      }
      System.out.println("\n");
      
      
      //test Deck class with one deck
      System.out.println("Display one deck, unshuffled:");
      deck.init(1);
      for (int i = deck.getTopCard(), cardCount = 0; i >= 0;i--, cardCount++)
      {
         System.out.print(deck.dealCard().toString() + " / ");
         if (cardCount == 5)
         {
            System.out.print("\n");
            cardCount = 0;
         }
      }
      System.out.println("\n");
      
      //test Deck class with two decks shuffled
      System.out.println("Display two decks, shuffled:");
      deck.init(2);
      deck.shuffle();
      for (int i = deck.getTopCard(), cardCount = 0; i >= 0;i--, cardCount++)
      {
         System.out.print(deck.dealCard().toString() + " / ");
         if (cardCount == 5)
         {
            System.out.print("\n");
            cardCount = 0;
         }
      }
      System.out.println("\n");
      

      //test Deck class with one deck shuffled
      System.out.println("Display one deck, shuffled:");
      deck.init(1);
      deck.shuffle();
      for (int i = deck.getTopCard(), cardCount = 0; i >= 0;i--, cardCount++)
      {
         System.out.print(deck.dealCard().toString() + " / ");
         if (cardCount == 5)
         {
            System.out.print("\n");
            cardCount = 0;
         }
      }
      System.out.println("\n");
      //END TESTS***************************************************************
      
      //PHASE 4: Implement a clean, short and completely tested client
      
      System.out.println("Welcome to our card game!");

      int MIN_PLAYERS = 1;
      int MAX_PLAYERS = 10;
      int numPlayers = 0;
      
      do
      {
         System.out.print("How many player (1-10)? ");
         numPlayers = keyboard.nextInt();
      }
      while(numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS);
      
      //instantiate a single-pack Deck
      Deck cardDeck = new Deck();
      
      //create Hands based on user input
      Hand[] playerHands = new Hand[numPlayers];
      
      for (int h = 0; h < numPlayers; h++)
      {
         playerHands[h] = new Hand();
      }
      
      //deal cards out to each hand use Hand.takeCard(Deck.dealCard())
      int k = 0; //counter
      while (cardDeck.topCard != -1)
      {
         playerHands[k].takeCard(cardDeck.dealCard());
         k++;
         
         //set counter back to 0 to keep looping through hands
         if (k == numPlayers)
         {
            k = 0;
         }
      }
      
      //display all hands
      System.out.println("Here are the hands from an unshuffled deck: ");
      for (int l = 0; l < playerHands.length; l++)
      {
         System.out.println(playerHands[l].toString());
      }
      System.out.println(""); //for space
      
      //reset all hands and deck
      for (int m = 0; m < playerHands.length; m++)
      {
         playerHands[m].resetHand();
      }
      cardDeck.init(1);
      
      //shuffle the deck
      cardDeck.shuffle();
      
      //deal cards to same number of players
      k = 0; //counter
      while (cardDeck.topCard != -1)
      {
         playerHands[k].takeCard(cardDeck.dealCard());
         k++;
         
         //set counter back to 0 to keep looping through hands
         if (k == numPlayers)
         {
            k = 0;
         }
      }
      
      //display all hands
      System.out.println("Here are the hands from a shuffled deck: ");
      
      for (int l = 0; l < playerHands.length; l++)
      {
         System.out.println(playerHands[l].toString());
      }
   }

}

//START class Card
/**
 * The Card class allows for the representation and manipulation of a single 
 * playing card as found in a standard 52 card deck.
 */
class Card
{
   /**
    * A public enum Suit stores the values of clubs, diamonds, hearts, spades;
    */
   public enum Suit
   {
      clubs, diamonds, hearts, spades;
   }
   
   /**
    * A public static final char cValue[] stores the values of each card 1-9 and 
    * T-A.  Ten is represented by 'T', not '10'.  
    */
   public static final char cValue[] = {'K', 'Q', 'J', 'T', '9', '8', '7', '6',
         '5', '4', '3', '2', 'A'};
   
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
    * @param suit = clubs, diamonds, hearts, spades
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
   /**
    * public boolean set(char value, Suit suit) checks that a valid card is being
    * set.
    * 
    * @param value 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'A'
    * @param suit clubs, diamonds, hearts, spades
    * @return this.errorflag true = error / bad card value
    */
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
    * @return this.suit, this.value, or this.errorFlag
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
   
   /**
    * public boolean equals(Card card) returns true if all the fields are
    * identical and false otherwise.
    * 
    * @param card
    * @return true or false
    */
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
      boolean isValid = false;
      
      //for (char index : validValues)
      for (char index : cValue)
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
         String card = Character.toUpperCase(value) + " of " + suit;
      return card;
      }
    } 
}
//END class Card

//START class Hand
/**
 * The Hand class represents the cards held by a single player
 */
class Hand
{
   public static final int MAX_CARDS = 52;
   
   private Card[] myCards;
   private int numCards;
   
   //Default constructor
   /**
    * There is a default Hand() constructor that creates an empty hand.  A hand
    * can hold no more than 52 cards, and the number of cards in the hand after
    * construction is 0.
    */
   public Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   
   /**
    * public void resetHand() resets an existing hand to 0 cards.
    */
   public void resetHand()
   {
      this.numCards = 0;
      this.myCards = null;
   }
   
   /**
    * public boolean takeCard(Card card) puts a new card in the players hand
    * and also checks that taking a new card would not violate the MAX_CARDS
    * allowed in the hand, which is set to MAX_CARDS = 52 by the Hand constructor.
    * @param card
    * @return true or false
    */
   public boolean takeCard(Card card)
   {
      boolean newCard = false;
      
      //checking if hand size plus card drawn will put us over max size
      if (numCards + 1 <= MAX_CARDS) 
      {
         myCards[numCards] = new Card(card.getValue(), card.getSuit());
         this.numCards++;
         newCard = true;
      }
      
      return newCard;
   }
   
   /**
    * public Card playCard() returns and removes the card in the top occupied 
    * position of the hand array.
    * @return a representation of the top card from the players hand
    */
   public Card playCard()
   {
      Card play = myCards[numCards-1];
      myCards[numCards-1] = null;
      this.numCards--;
      return play; 
   }
   
   /**
    * toString() concatenates the cards in the hand into a single string.
    * 
    * @param none
    * @return Returns a string
    */
   public String toString()
   {

      int cardCounter = 0;
      int handCards = 0;
      StringBuilder hand = new StringBuilder("Hand = ( ");

      if (this.numCards > 0)
      {
         for (Card card:myCards)
         {
            if (card == null) 
            {
               break;
            }
            hand.append(card.toString());
            if(handCards < this.numCards - 1) 
            {
               hand.append(", ");
            }
            cardCounter++;
            handCards++;
            
            //if statement below formats the output onto multiple lines
            if (cardCounter % 5 == 0 && handCards != this.numCards)
            {
               hand.append("\n");
               cardCounter = 0;
            }
         }
      }
      
      hand.append(" )");
      return hand.toString();
   }
   
   /**
    * 
    * @return
    */
   public int getNumCards()
   {
      return this.numCards;
   }
   
   public Card inspectCard(int k)
   //should we add a check to see if the int k is out of bounds of the array
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
      allocateMasterPack();
      init(1);
   }

   public Deck(int numPacks)
   {
      allocateMasterPack();
      init(numPacks);
   }

   public void init(int numPacks)
   {
      cards = new Card[numPacks * 52];
      for (int i = 0; i < numPacks; i++)
      {
         System.arraycopy(masterPack, 0, this.cards, i * masterPack.length,
            masterPack.length);
      }
      if ((numPacks * 52) > MAX_CARDS)
         topCard = MAX_CARDS - 1;
      else
         topCard = (numPacks * 52) - 1;
   }
   
   public void shuffle() 
   {
      Random shuffle = new Random();
      
      for (int i=0; i < cards.length; i++) 
      {
         int randomIndex = i + shuffle.nextInt(cards.length - i);
         Card swap = cards[randomIndex];
         cards[randomIndex] = cards[i];
         cards[i] = swap;
      }
   }
   
/*
returns a card while topCard is not negative, otherwise return null
*/
   public Card dealCard()
   {
      if (topCard != -1) //since a card is stored at 0, deck is empty at -1
         return cards[topCard--];
      return null;
   }

   public int getTopCard()
   {
      return topCard;
   }
/**
 * 
 * @param k
 * @return a card with errorFlag = true if k is out of bounds
 * return card otherwise.
 */
   public Card inspectCard(int k)
   {
      if (k <= topCard)
         return cards[k];
      return new Card('X', Card.Suit.clubs);
   }

   private static void allocateMasterPack()
   {
      int k = 0; //for deck array number
      
      if (masterPack[0] != null)
         return;
      
      for (int i = 0; i < Card.Suit.values().length; i++)
      {
         for (int j = 0; j < Card.cValue.length; j++)
         {
            masterPack[k++] = new Card(Card.cValue[j], Card.Suit.values()[i]);
         }
      }
   }
}