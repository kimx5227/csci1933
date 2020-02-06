import java.util.Scanner;
/*records and returns fewest denomination of coins*/
public class ChangeCount{
        public static void main(String[] args){
                int quarters; //quarter count
                int dimes; //dimes count
                int nickels; //nickel count
                int pennies; //penny count

                Scanner askUser = new Scanner(System.in); //asks for user's amount of money
                System.out.println("How much money do you have?");
                float money = askUser.nextFloat();

                quarters = (int)(money / .25);                  //*finds highest number of coins possible for each denomination
                money = money - (float)(.25 * quarters);
                dimes = (int)(money/.1);
                money = money - (float)(.1 * dimes);
                nickels = (int)(money / .05);
                money = money - (float)(.05 * nickels);
                pennies = (int)(money / .01);

                System.out.println("You have:"); //Prints out number of coins
                System.out.println(quarters + " quarters");
                System.out.println(dimes + " dimes");
                System.out.println(nickels + " nickels");
                System.out.println(pennies + " pennies");
        }
}
