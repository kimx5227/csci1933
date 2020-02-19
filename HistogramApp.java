import java.util.Scanner;

public class HistogramApp{

        public static void main(String[] args){
          Scanner askUser = new Scanner(System.in);
          String action, addStr;
          String prtStr = "";
          int addNumb, lob, upb;
          boolean again = true;
          String up = "";
          String lb = "";





          System.out.println("enter lb");
          lb = askUser.nextLine();
          System.out.println("enter up");
          up = askUser.nextLine();
          lob = Integer.parseInt(lb);
          upb = Integer.parseInt(up);
          System.out.println(lob);
          System.out.println(upb);
          Histogram hist = new Histogram(lob,upb);
          while(again == true){
              System.out.println("Give an action:");
              action = askUser.nextLine();
              if (action.equals("add")){
                  System.out.println("enter number in range");
                  addStr = askUser.nextLine();
                  addNumb = Integer.parseInt(addStr);
                  if (hist.add(addNumb)==false){
                      System.out.println("That is not correct");
                  }
              } else if (action.equals("print")){
                  System.out.println(hist);
              } else if (action.equals("quit")){
                  again = false;
              } else {
                System.out.println("Please enter again");
              }
        }
      }

}
