import java.util.Scanner;
/*asks users first and last name and returns the first and last name
  separately, with the count of letters in the name*/
public class NameSeparate{
        public static void main(String[] args){
                String firstName;
                String lastName;
                int nameSplit; //position where space between first and last name is
                Scanner userInput = new Scanner(System.in);

                System.out.println("What is your name?");
                System.out.println("Please format as follows: e.g. \"Mary Hopkins\"");
                String name = userInput.nextLine();
                nameSplit = name.indexOf(" "); //Finds where the space is for the name
                firstName = name.substring(0,nameSplit); //Finds substring of first name
                lastName = name.substring(nameSplit + 1); //Finds substring of last name
                System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
                System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters");
                System.out.println("Your initials are " + firstName.charAt(0)+lastName.charAt(0));
        }
}
