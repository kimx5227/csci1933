/*Simulates the roll of 2 dice and adds sum*/
public class DiceRoll {
        public static void main(String[] args){
                int dice1 = (int)(6 * Math.random()) + 1;
                int dice2 = (int)(6 * Math.random()) + 1;
                System.out.println("The first die comes up " + dice1);
                System.out.println("The second die comes up " + dice2);
                System.out.println("Your total roll is " + (dice1 + dice2));
        }
}
