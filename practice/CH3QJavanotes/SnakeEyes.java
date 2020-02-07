public class SnakeEyes{

        public static void main(String[] args){

                boolean keepRolling = true;
                int diceRoll1;
                int diceRoll2;
                int numOfRolls = 0;

                while (keepRolling) {
                  diceRoll1 = (int)(6 * Math.random()) + 1;
                  diceRoll2 = (int)(6 * Math.random()) + 1;
                  numOfRolls++;
                  if (diceRoll1 == diceRoll2 && diceRoll1 == 1) {
                    keepRolling = false;
                  }
                }
                System.out.print("It took " + numOfRolls + " rolls to get snake eyes!");
        }


}
