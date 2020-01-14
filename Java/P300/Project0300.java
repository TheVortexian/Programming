/**
*@description: Project where I print a chimpanzee or something
*@author: Connor Leu
*@since: 9/10/2019
*/
import java.util.Scanner;
public class Project0300 {

   public static void main(String[] args) {
      // Get all input for the "chimp"
      Scanner s = new Scanner(System.in);
      System.out.println("Enter position [sleeping or not sleeping]: ");
      String position = s.nextLine();
      System.out.println("Enter ear size [small, tiny, large, big]: ");
      String earSize = s.nextLine();
      System.out.println("Enter if in tree [true or false]: ");
      boolean inTree = s.nextLine().equals("true") ? true : false;
      System.out.println("Enter if standing [true or false]: ");
      boolean standing = s.nextLine().equals("true") ? true : false;
      printChimp(position, earSize, inTree, standing);
      s.close();
   }
   
   //wrapper function
   public static void printChimp(String position, String earSize, boolean inTree, boolean standing) {
      drawTop(earSize, position);
      drawBody(inTree);
      drawBottom(standing);
   }
   
   public static void drawBottom(boolean standing) {
      String bottom = "";
      if (standing) {
      //2 \t and 6 spaces, and then uwu
         bottom = "\n\t\t     /       __\t  |\n" +
                  "\t\t     |      /\t\\\t  |\n" +
                  "\t\t     |     | \t |\t  |\n" +
                  "\t\t     |     | \t |\t  |\n" +
                  "\t\t     |     | \t |\t  |\n" +
                  "\t\t     \\    /  \t \\\t  / \n" +
                  "\t\t      ¯¯¯¯       ¯¯¯";
      } else {
         bottom = "\n ____________________________________\n" +
                  "/                 |                  \\\n" +
                  "\\________________\\ /_________________/\n";
      }
      System.out.print(bottom);
   }
   public static void drawBody(boolean inTree) {
      String body = "";
      
      if (inTree) {
         body = "\n\t\t¤¤¤¤¤¤\n" + 
                "\t\t¤¤\\¤¤\t\\   \t\t----\n" + 
                "\t\t  ¤\\¤\t \\   \t\t    o\n" +
                "\t\t   E\\---|    \t\t  o\n" + 
                "\t\t    /  /     \t\t |\n" +
                "\t\t       ¯¯¯¯¯¯¯¯¯¯¯¯¯";
      }
      else if (!inTree) {
         body = "\t\t    \n" + 
                "\t\t    \t\\   \t\t----\n" + 
                "\t\t     \t \\   \t\t    o\n" +
                "\t\t       | --3 \t\t |--3\n" + 
                "\t\t       /     \t\t |\n" + 
                "\t\t      /      \t\t |\n" + 
                "\t\t      |      \t\t  \\\n" +
                "\t\t      ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
      }
      System.out.print(body);
   }
   public static void drawTop(String earSize, String position) {
      String top = "";
      char eye = '™';
      if (position.equals("sleeping")) {
         eye = 'x';
      }
      //default size will be large
      if (!earSize.equals("large") && !earSize.equals("small") && !earSize.equals("big") && !earSize.equals("tiny")) {
         earSize = "large";
      }
      if (earSize.equals("large") || earSize.equals("big")) {
         top = "\t\t *** \t\t***\t\t*** \n" +
               "\t\t *** \t          \t*** \n" + 
               "\t\t    *\t* "+eye+"  "+eye+"  *   * \n" +
               "\t\t     \t* -__-  * \n" +
               "\t\t     \t ¯¯¯¯¯¯¯ ";
      } else if (earSize.equals("small") || earSize.equals("tiny")) {
         top = "\t\t    *\t\t***\t*\t  \n" +
               "\t\t     \t*       * \t    \n" + 
               "\t\t     \t* ™  ™  *     \n" +
               "\t\t     \t* -__-  * \n" +
               "\t\t     \t ¯¯¯¯¯¯¯ ";
      }
      System.out.print(top);
   }

}