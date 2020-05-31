//Written by kimx5227
public class BattleboatsBoard{

        private int[][] board;

        //creates board based on difficulty
        public BattleboatsBoard(String difficulty){
            difficulty = difficulty.toLowerCase();
            if (difficulty.equals("standard")){
                board = new int[8][8];
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        board[i][j] = 0;
                    }
                }
            } else if (difficulty.equals("expert")){
                board = new int[12][12];
                for (int i = 0; i < 12; i++){
                    for (int j = 0; j < 12; j++){
                        board[i][j] = 0;
                    }
                }
            }
        }

        public BattleboatsBoard(){}

        public int[][] getBoard(){
            return board;
        }

        public void setBoardPos(int x, int y, int val){
            board[x][y] = val;
        }

        //board user sees each turn
        public void displayBoard(){
            char posChar = 'X';
            for (int row = 0; row < board.length + 1; row++){
                for (int col = 0; col < board.length + 1; col++){
                    if (col < 10)
                        System.out.print("  ");
                    else
                        System.out.print(" ");
                    if (row == 0 && col !=0 && col > 10){ // col/row >10 ensures board prints correctly since
                        System.out.print(col-1);           // 10, 11, 12 has an extra digit
                        System.out.print("  ");
                    } else if (row == 0 && col !=0){
                        System.out.print(col-1);
                        System.out.print("  ");
                    } else if (row == 0 && col == 0){
                        System.out.print("(x,y) ");
                    } else if (col == 0 && row > 10){
                        System.out.print(" ");
                        System.out.print(row-1);
                        System.out.print("  ");
                    } else if (col == 0){
                        System.out.print("  ");
                        System.out.print(row-1);
                        System.out.print("  ");
                    } else if (board[row-1][col-1] == 0 && col > 10){
                        System.out.print("  - ");
                    } else if (board[row-1][col-1] == 0){
                        System.out.print(" - ");
                    } else if (col > 10){
                      if (board[row-1][col-1] == 1){
                          posChar = 'X';
                      } else {
                          posChar = 'O';
                      }
                        System.out.print(" ");
                        System.out.print(posChar);
                        System.out.print(" ");
                    } else {
                      if (board[row-1][col-1] == 1){
                          posChar = 'X';
                      } else {
                          posChar = 'O';
                      }
                        System.out.print(" ");
                        System.out.print(posChar);
                        System.out.print(" ");
                    }
                }
                System.out.println("");
                System.out.println("");
            }
        }

        //prints complete board to user to check validity of actions
        public void printBoard(){
            System.out.println("The completed board is: ");
            System.out.println("");
            for (int row = 0; row < board.length + 1; row++){
                for (int col = 0; col < board.length + 1; col++){
                    if (col < 10)
                        System.out.print("  ");
                    else
                        System.out.print(" ");
                    if (row == 0 && col !=0 && col > 10){ // col/row >10 ensures board format is correct since
                        System.out.print(col-1);         // 10, 11, 12 has an extra digit
                        System.out.print("  ");
                    } else if (row == 0 && col !=0){
                        System.out.print(col-1);
                        System.out.print("  ");
                    } else if (row == 0 && col == 0){
                        System.out.print("(x,y) ");
                    } else if (col == 0 && row > 10){
                        System.out.print(" ");
                        System.out.print(row-1);
                        System.out.print("  ");
                    } else if (col == 0){
                        System.out.print("  ");
                        System.out.print(row-1);
                        System.out.print("  ");
                    } else if (board[row-1][col-1] == 0 && col > 10){
                        System.out.print("  - ");
                    } else if (board[row-1][col-1] == 0){
                        System.out.print(" - ");
                    } else if (col > 10){
                        System.out.print("  ");
                        System.out.print((int)Math.floor(board[row-1][col-1] / 10));
                        System.out.print(" ");
                    } else {
                        System.out.print(" ");
                        System.out.print((int)Math.floor(board[row-1][col-1] / 10));
                        System.out.print(" ");
                    }
                }
                System.out.println("");
                System.out.println("");
            }
        }

        //Checks if the boat is sunk by checking the vertical and horizontal directions
        public boolean isSunk(int row, int col, int[][] board){
            int boatLength = board[row][col] / 10;
            int boatNumb = board[row][col] % 10;
            int sinkCount = 0;
            if (!checkRight(row, col, boatLength) || !checkLeft(row, col, boatLength)){
                for (int i = 0; i < board.length; i++){
                    if (this.board[row][i] == 1){
                        if (board[row][i] / 10 == boatLength && board[row][i] % 10 == boatNumb){
                            sinkCount ++;
                        }
                    }
                }
            }
            System.out.println(sinkCount);
            if (sinkCount == boatLength){
                return true;
            }

            sinkCount = 0;

            if (!checkUp(row, col, boatLength) || !checkDown(row, col, boatLength)){
                for (int i = 0; i < board.length; i++){
                    if (this.board[i][col] == 1){
                        if (board[i][col] / 10 == boatLength && board[i][col] % 10 == boatNumb){
                            sinkCount ++;
                        }
                    }
                }
            }
            System.out.println(sinkCount);
            if (sinkCount == boatLength){
                return true;
            }
            return false;

        }

        //checks possible results from fire action
        public int fireResult(BattleboatsBoard other, int row, int col){
            int extraMoves = 0;
            if (row > board.length || row < 0){
                System.out.println("That isn't a valid row. Penalty");
                extraMoves = 1;
            } else if (col > board.length || col < 0){
                System.out.println("That isn't a valid column. Penalty");
                extraMoves = 1;
            } else if (other.getBoard()[row][col] == -1 || other.getBoard()[row][col] == 1){
                System.out.println("You've already fired there. Penalty");
                extraMoves = 1;
            } else if (board[row][col] == 0){
                System.out.println("You missed.");
                other.setBoardPos(row, col, -1);
            } else {
                other.setBoardPos(row, col, 1);
                if (other.isSunk(row, col, board)){
                    System.out.println("You've sunk a boat!");
                } else {
                    System.out.println("You've hit a boat!");
                }
            }
            return extraMoves;
        }

        public void drone(String dir, int pos){
              int spots = 0;
              if (dir.equals("column")){
                  for (int i = 0; i < board.length; i ++){
                      if (board[i][pos] != 0)
                        spots ++;
                  }
              } else {
                  for (int j = 0; j < board.length; j ++){
                      if (board[pos][j] != 0)
                        spots ++;
                  }
              }
              System.out.println("There are " + spots + " spots in the direction you chose.");
        }

        public void missile(BattleboatsBoard other, int row, int col){
            for (int i = row - 1; i < row + 2; i++){
                if (i > -1 && i < board.length){
                    for (int j = col - 1; j < col + 2; j++){
                            if (j > -1 && j < board.length){
                                if (board[i][j] != 0){
                                    other.setBoardPos(i, j, 1);
                                } else {
                                    other.setBoardPos(i, j, -1);
                                }
                            }
                    }
                }
            }
        }

        public boolean checkRight(int row, int col, int len){
            boolean openSpace = true;
            if (col + len < board.length){
                for (int rightPos = 1; rightPos < len; rightPos++){
                    if (board[row][col + rightPos] != 0){
                        openSpace = false;
                        break;
                    }
                }
            } else {
                openSpace = false;
            }
            return openSpace;
        }

        public boolean checkLeft(int row, int col, int len){
            boolean openSpace = true;
            if (col - len > 0){
                for (int leftPos = 1; leftPos < len; leftPos++){
                    if (board[row][col - leftPos] != 0){
                        openSpace= false;
                        break;
                    }
                }
            } else {
                openSpace = false;
            }
            return openSpace;
        }

        public boolean checkUp(int row, int col, int len){
            boolean openSpace = true;
            if (row - len > 0){
                for (int upPos = 1; upPos < len; upPos++){
                  if (board[row - upPos][col] != 0){
                      openSpace = false;
                      break;
                  }
                }
            } else {
                openSpace = false;
            }
            return openSpace;
        }

        public boolean checkDown(int row, int col, int len){
            boolean openSpace = true;
            if (row + len < board.length){
                for (int downPos = 1; downPos < len; downPos++){
                    if (board[row + downPos][col] != 0){
                        openSpace = false;
                        break;
                    }
                }
            } else {
                openSpace = false;
            }
            return openSpace;
        }

        public int chooseDirections(int row, int col, int length){
              int[] possibleDirections = new int[4];
              boolean valid; //variable validating possible direction
              int possibleDir, randomDir;
              double random;
              possibleDir = 0; //counts # of possible directions
              randomDir = 0;
              length = (int) Math.floor(length / 10);

              //each possible direction is stored in possibleDirections
              //and is randomly chosen
              valid = checkRight(row, col, length);
              if (valid == true){
                  possibleDirections[possibleDir] = -2;
                  possibleDir ++;
              }

              valid = checkLeft(row, col, length);
              if (valid == true){
                  possibleDirections[possibleDir] = -1;
                  possibleDir ++;
              }

              valid = checkUp(row, col, length);
              if (valid == true){
                  possibleDirections[possibleDir] = 1;
                  possibleDir ++;
              }

              valid = checkDown(row, col, length);
              if (valid == true){
                  possibleDirections[possibleDir] = 2;
                  possibleDir ++;
              }

              if (possibleDir > 0) {
                  random = Math.random() * possibleDir;
                  randomDir = (int) random;
                  randomDir = possibleDirections[randomDir];
              }
              return randomDir;

        }

        //randomly fills the board with specified boat length
        public void populateBoard(int row, int col, int direction, int len){
            if (direction == -2){
                for (int j = 0; j < Math.floor(len / 10); j++){
                    board[row][col + j] = len;
                }
            }
            if (direction == -1){
                for (int j = 0; j < Math.floor(len / 10); j++){
                    board[row][col - j] = len;
                }
            }
            if (direction == 1){
                for (int j = 0; j < Math.floor(len / 10); j++){
                    board[row - j][col] = len;
                }
            }
            if (direction == 2){
                for (int j = 0; j < Math.floor(len / 10); j++){
                    board[row + j][col] = len;
                }
            }
        }

        //each integer in list is of the form "abc", where the a digit denotes the boat length,
        //the b digit denotes the boat number (distinugishes same length boats), and the c digit
        //denotes the hit value (0 = not fired on, 1 = hit boat, 2 = miss)
        public void randomBoats(int numBoats){
            int xCor, yCor, direction, boatNumb;
            boatNumb = 1;
            while (numBoats > 0){
                for (int i = 5; i > 1; i--){ //populates each boat length from 2 to 5 once
                    int j = i * 10 + boatNumb;
                    xCor = (int)(Math.random() * board.length);
                    yCor = (int)(Math.random() * board.length);
                    direction = chooseDirections(yCor, xCor, j);
                    while (board[yCor][xCor] != 0 || direction == 0){
                        xCor = (int)(Math.random() * board.length);
                        yCor = (int)(Math.random() * board.length);
                        direction = chooseDirections(yCor, xCor, j);
                    }
                    populateBoard(yCor, xCor, direction, j);
                } // end of populating each length from 2 to 5

                xCor = (int)(Math.random() * board.length);
                yCor = (int)(Math.random() * board.length);
                boatNumb ++;
                direction = chooseDirections(yCor, xCor, 3 * 10 + boatNumb);
                while (board[yCor][xCor] != 0 || direction == 0){
                    xCor = (int)(Math.random() * board.length);
                    yCor = (int)(Math.random() * board.length);
                    direction = chooseDirections(yCor, xCor, 3 * 10 + boatNumb);
                }

                populateBoard(yCor, xCor, direction, 3 * 10 + boatNumb);
                numBoats = numBoats - 5;
                boatNumb ++;
            }
        }

        public boolean equals(BattleboatsBoard other){
            for (int row = 0; row < this.board.length; row++){
                for (int col = 0; col < this.board.length; col++){
                  if (this.board[row][col] != 0){
                    if (other.getBoard()[row][col] != 1)
                        return false;
                  }
                }
            }
            return true;

        }

}
