import java.util.Scanner;
/*asks for user input and responds with greeting*/
public class Greeter{
        public static void main(String[] args){
              Scanner askUser = new Scanner(System.in); //creates new scanner object
              System.out.println();
              System.out.println("What is your name");
              String name = askUser.nextLine();
              name = name.toUpperCase();
              System.out.println();
              System.out.println("Hello " + name + ", have a good day");
        }
}
