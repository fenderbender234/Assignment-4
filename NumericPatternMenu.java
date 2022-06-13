/* 
* @author Josh Freeman
*/

import java.util.*;

/**
* 
* The function below is used to validate if the user entered number is a valid integer
* If the number is valid, then it is returned
* Else, an exception is thrown and the user is asked to enter the number again
*
*/
public class NumericPatternMenu {

   public static int validateInt(String prompt, Scanner keyboard) {
       
       // Instantiate scanner
       //Scanner keyboard = new Scanner(System.in);
       
       // instantiate integer variable for user input
       int x;
       
       // loop until valid number is given
       while(true) {
           
           try {
               System.out.print(prompt);
               x = keyboard.nextInt();
               return x;
           }
           catch(NumberFormatException e) {
               System.out.println(e.getMessage() + "\n");
           }
           catch(InputMismatchException e) {
               System.out.println("ERROR. Number entered is not an integer.\n");
               keyboard.next();
               continue;
           }
       }
   }
   
   /**
    * 
    * @param size
    * @param direction
    * @return
    * @throws IllegalArgumentException
    * 
    * Function generates pattern of the given size
    * If direction is true, pattern increases first then decreases
    * Else, decrease first then increase
    */
      public static String numericPattern(int size,boolean direction) throws IllegalArgumentException {
          
          // Instantiate result
          String result = "";
          
          // if size is less than or equal to 0, show error
          if(size <= 0) {
              
              throw new IllegalArgumentException("ERROR. Number entered is not positive.\n");
              
          }
          
          // if direction is true, start loop from 1
          if(direction == true) {
              
              for(int i = 1;i <= size; i++) {
                  result += i;
              }
              
              for(int j = size -1; j >= 1; j--) {
                  result += j;
              }
          }
          
          // if direction == false
          else if(direction == false) {
              
              for(int j = size; j >= 1; j--) {
                  result += j;
              }
              for(int i = 2; i <= size; i++) {
                  result += i;
              }
          }
          // if size = 1, show 1 regardless
          else if(size == 1) {
              result = "1";
          }
          return result;
          
      }
   
   /**
    * Function displays pattern from numericPattern();
    */
   
   public static void patternOut(int size, boolean direction) {
       
       System.out.println(numericPattern(size,direction) + "\n");
   }
   
   /**
    * Function prints the menu for user
    */
   
   public static int menu(Scanner keyboard) {
       
       int choice = validateInt("Numeric Pattern Display\n" +
                                "1. Print Type 1 pattern (like 12321)\n"+
                                "2. Print Type 2 pattern (like 32123)\n"+
                                "3. Quit \nEnter your choice (1 - 3): ",keyboard);
       
       return choice;
   }
   
   public static void main(String[] args) {
       
       
       // Instantiate variables
       int size;
       int y = 0;
       Scanner keyboard = new Scanner(System.in);
       
       // While loop for menu
       while(y != 3) {
           
           y = menu(keyboard);
           switch(y) {
           
           case 1:
               do {
                   
                   size = validateInt("Please enter the size of the pattern. The size must be a positive integer:",keyboard);
                   
                   if(size <= 0)
                       System.out.println("ERROR. Number entered is not positive.\n");
           } while (size <= 0);
               patternOut(size,true);
               break;
               
           case 2:
               do {
                   size = validateInt("Please enter the size of the pattern. The size must be a positive integer:",keyboard);
                   
                   if(size <= 0)
                       System.out.println("ERROR. Number entered is not positive.\n");
               }
               while(size <= 0);
               patternOut(size,false);
               break;
               
           case 3:
               System.out.println("Quitting!");
               return;
           
           default:
               if(y < 0 || y > 3) {
               System.out.println("ERROR. Number entered is not a valid selection.\n");
               }
               else {
                   System.out.println("ERROR. Number entered is not an integer.\n");
               }
           }
       }
   }
}