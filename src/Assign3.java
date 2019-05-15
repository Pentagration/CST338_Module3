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
      this.value = 'A';
      this.suit = Suit.spades;
   }
   
   //Constructor
   public Card(char value, Suit suit)
   {
      this.value = value;
      this.suit = suit;
   }
   
  
}