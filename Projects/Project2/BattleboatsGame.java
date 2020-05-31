//Written by kimx5227
import java.util.Scanner;

//main method for Battleboats game
public class BattleboatsGame{

        public static void main(String[] args){
            boolean continueAsking, gameContinue; //variabless used to denote continuity of start phase and end phase of game
            String difficulty, move; //used to take in user input
            int cannonShots = 0;
            int moveCount = 0;
            int xPos = 0;
            int yPos = 0;
            int boardLength = 0;
            Scanner askUser = new Scanner(System.in);
            continueAsking = true;
            gameContinue = true;

            System.out.println("What difficulty would you like?: standard or expert");
            //loop initiates game
            while (continueAsking){
                int numBoats, missiles, drones;
                difficulty = askUser.next();
                difficulty = difficulty.toLowerCase();
                difficulty = difficulty.trim();
                if (difficulty.equals("standard") || difficulty.equals("expert")){
                    System.out.println("");
                    System.out.println("You have chosen to play " + difficulty + " difficulty");
                    BattleboatsBoard randomBoard = new BattleboatsBoard(difficulty);
                    BattleboatsBoard currentBoard = new BattleboatsBoard(difficulty);
                    continueAsking = false;
                    if (difficulty.equals("standard")){
                        numBoats = 5;
                        missiles = 1;
                        drones = 1;
                        boardLength = 8;
                    } else {
                        numBoats = 10;
                        missiles = 2;
                        drones = 2;
                        boardLength = 12;
                    } //end of initilization of game
                    randomBoard.randomBoats(numBoats);
                    System.out.println("There are: " + numBoats + " total boats.");
                    //start of loop for gameplay
                    while (gameContinue){
                        randomBoard.printBoard();
                        System.out.println("");
                        currentBoard.displayBoard();
                        System.out.println("Missiles left: " + missiles + " Drones left: " + drones);
                        System.out.println("Moves made: " + moveCount);
                        System.out.println("Cannon shots fired: " + cannonShots);
                        System.out.println("Choose an action by typing \"drone,\" \"missile,\" or \"fire.\": ");
                        move = askUser.next();

                        if (move.equals("missile")){
                            if(missiles > 0){
                                System.out.println("Please type the row number you'd like to fire on");
                                String x = askUser.next();
                                x = x.toLowerCase();
                                x = x.trim();
                                xPos = Integer.parseInt(x);
                                while (xPos < 0 || xPos > boardLength - 1){
                                    System.out.println("Please type the row number you'd like to fire on");
                                    x = askUser.next();
                                    x = x.toLowerCase();
                                    x = x.trim();
                                    xPos = Integer.parseInt(x);
                                }
                                System.out.println("Please type the column number you'd like to fire on");
                                String y = askUser.next();
                                y = y.toLowerCase();
                                y = y.trim();
                                yPos = Integer.parseInt(y);
                                while (yPos < 0 || yPos > boardLength - 1){
                                    System.out.println("Please type the column number you'd like to fire on");
                                    y = askUser.next();
                                    y = y.toLowerCase();
                                    y = y.trim();
                                    yPos = Integer.parseInt(y);
                                }
                                randomBoard.missile(currentBoard,xPos,yPos);
                                moveCount ++;
                                missiles --;
                            } else{
                                moveCount ++;
                                System.out.println("You have no more missiles, your turn has been skipped.");
                            }

                        } else if (move.equals("drone")){
                            if (drones > 0){
                                System.out.println("Please type \"column\" or \"row\"");
                                String direction = askUser.next();
                                direction = direction.toLowerCase();
                                direction = direction.trim();
                                while (!direction.equals("column") && !direction.equals("row")){
                                    System.out.println("Please type \"column\" or \"row\"");
                                    direction = askUser.next();
                                    direction = direction.toLowerCase();
                                    direction = direction.trim();
                                }
                                System.out.println("Choose the row/column number to check");
                                String position = askUser.next();
                                position = position.toLowerCase();
                                position = position.trim();
                                int posInt = Integer.parseInt(position);
                                while (posInt < 0 || posInt > boardLength - 1){
                                    System.out.println("Please enter a valid position");
                                    position = askUser.next();
                                    position = position.toLowerCase();
                                    position = position.trim();
                                    posInt = Integer.parseInt(position);
                                }
                                randomBoard.drone(direction, posInt);
                                moveCount ++;
                                drones --;
                            } else {
                                moveCount ++;
                                System.out.println("You have no more drones, your turn has been skipped.");
                            }

                        } else if (move.equals("fire")){
                            System.out.println("Input the row you want to fire:");
                            xPos = askUser.nextInt();
                            System.out.println("Input the column you want to fire:");
                            yPos = askUser.nextInt();
                            System.out.println("You fired at position: (" + xPos + "," + yPos + ").");
                            moveCount = moveCount + randomBoard.fireResult(currentBoard, xPos, yPos); //adds penalty if needed
                            moveCount ++;
                            cannonShots ++;
                        } else if (move.equals("print")){
                            randomBoard.printBoard();
                        } else {
                            System.out.println("You inputted an incorrect action. Your turn has been skipped.");
                            moveCount ++;
                        }
                        if (randomBoard.equals(currentBoard)){
                            gameContinue = false;
                            System.out.println("");
                            System.out.println("Congratulations, you sunk all the boats with " + moveCount + " moves.");
                            System.out.println("You fired " + cannonShots + "cannon shots.");
                        }
                    }
                } else {
                    System.out.println("");
                    System.out.print("That is an invalid input, please type");
                    System.out.println(" \"standard\" or \"expert\"");
                }
            }// end of gameplay loop
        }// end of main()
}
