// Names:Blake Kim
// x500s: kimx5227

import java.util.Random;

public class MyMaze{

    private Cell[][] maze;

    public MyMaze(int rows, int cols)
    {
        maze = new Cell[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
                maze[i][j] = new Cell();
        }
    }

    //getter and setter to manipulate the cells
    public Cell[][] getMaze(){return maze;}
    public void setMaze(Cell[][] newMaze){maze = newMaze;}

    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int rows, int cols)
    {
        MyMaze returnedMaze= new MyMaze(rows, cols);
        Cell[][] newMaze = returnedMaze.getMaze();
        Stack1Gen<String> path = new Stack1Gen<String>();
        boolean[] possibleDir = new boolean[4]; //List containing valid directions to move at current position
        boolean isValidPath;
        String nextCell, topStr; //nextCell denotes the next direction that we'll move to after
        String[] topSplit = new String[2]; //used to store the vertical and horizontal entries
        Random rnd = new Random();
        int randDir, vertEntry, horEntry;//randomDir holds random value related to its direction

        newMaze[0][0].setVisited(true);
        path.push("0,0");
        //start of outer loop
        while (! path.isEmpty())
        {
            isValidPath = false;
            topStr = path.top();
            topSplit = topStr.split(",", 2);
            vertEntry = Integer.parseInt(topSplit[0]);
            horEntry = Integer.parseInt(topSplit[1]);

            //checks if the down direction is valid and is not visited
            if (vertEntry + 1 >= 0 && vertEntry + 1 < rows)
            {
                if (! newMaze[vertEntry + 1][horEntry].getVisited())
                {
                    possibleDir[0] = true;
                    isValidPath = true;
                }
            }

            //checks if the up direction is valid and is not visited
            if (vertEntry - 1 >= 0 && vertEntry - 1 < rows)
            {
                if (! newMaze[vertEntry - 1][horEntry].getVisited())
                {
                    possibleDir[1] = true;
                    isValidPath = true;
                }
            }

            //checks if the right direction is valid and is not visited
            if (horEntry + 1 >= 0 && horEntry + 1 < cols)
            {
                if (! newMaze[vertEntry][horEntry + 1].getVisited())
                {
                    possibleDir[2] = true;
                    isValidPath = true;
                }
            }

            //checks if the left direction is valid and is not visited
            if (horEntry - 1 >= 0 && horEntry - 1 < cols)
            {
                if (! newMaze[vertEntry][horEntry - 1].getVisited())
                {
                    possibleDir[3] = true;
                    isValidPath = true;
                }
            }

            if (isValidPath)
            {
                //start of inner loop
                while (true)
                {
                    randDir = rnd.nextInt(4);

                     // Call this case, "*" , sets random path to the cell below, sets cell as visited, and takes down barrier
                    if (randDir == 0 && possibleDir[randDir])
                    {
                        newMaze[vertEntry][horEntry].setBottom(false);
                        vertEntry ++;
                        newMaze[vertEntry][horEntry].setVisited(true);
                        nextCell = Integer.toString(vertEntry);
                        nextCell = nextCell + "," + Integer.toString(horEntry);
                        path.push(nextCell);
                        break;
                    }

                    //does the same as * to cell above current position
                    else if (randDir == 1 && possibleDir[randDir])
                    {
                        vertEntry --;
                        newMaze[vertEntry][horEntry].setVisited(true);
                        newMaze[vertEntry][horEntry].setBottom(false);
                        nextCell = Integer.toString(vertEntry);
                        nextCell = nextCell + "," + Integer.toString(horEntry);
                        path.push(nextCell);
                        break;
                    }

                    //does the same as * to cell to the right of current position
                    else if (randDir == 2 && possibleDir[randDir])
                    {
                        newMaze[vertEntry][horEntry].setRight(false);
                        horEntry ++;
                        newMaze[vertEntry][horEntry].setVisited(true);
                        nextCell = Integer.toString(vertEntry);
                        nextCell = nextCell + "," + Integer.toString(horEntry);
                        path.push(nextCell);
                        break;
                    }

                    //does the same as * to the cell to the left of current position
                    else if (randDir == 3 && possibleDir[randDir])
                    {
                        horEntry --;
                        newMaze[vertEntry][horEntry].setVisited(true);
                        newMaze[vertEntry][horEntry].setRight(false);
                        nextCell = Integer.toString(vertEntry);
                        nextCell = nextCell + "," + Integer.toString(horEntry);
                        path.push(nextCell);
                        break;
                    }
                }//end of inner loop
                for (int i = 0; i < 4; i++)
                    possibleDir[i] = false;
            }

            else
            {
                path.pop();
            }
        }//end of outer loop
        System.out.println("");
        newMaze[newMaze.length-1][newMaze[0].length-1].setRight(false);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
                newMaze[i][j].setVisited(false);
        }
        returnedMaze.setMaze(newMaze);
        return returnedMaze;
    }//end of makeMaze

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze(boolean path)
    {

        //-1 and maze.length + 1 are the barriers above and below maze's rows
        for (int i = -1; i < maze.length + 1; i++)
        {
            for (int j = -1; j < maze[0].length; j++)
            {

                //case excludes j==-1, since that gives an extrabarrier
                if ((i == -1 || i == maze.length) && j != -1)
                    System.out.print("|---");

                //this case prints left barriers/entrace of maze
                else if (j == -1)
                {
                    if (!(i == -1 || i == maze.length))
                    {
                        if (i == 0)
                            System.out.print(" ");
                        else
                            System.out.print("|");
                    }
                }

                //prints maze cells and right barriers between cells
                else
                {
                    if (maze[i][j].getVisited() && path)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");

                    if (maze[i][j].getRight())
                        System.out.print("|");
                    else
                        System.out.print(" ");
                }
            }

            //prints final right barriers/entrance
            if (i == -1 || i == maze.length)
                System.out.println("|");
            else
                System.out.println("");

            //prints down barriers/empty space between cells
            if (i != -1 && i < maze.length - 1)
            {
                for (int j = 0; j < maze[0].length; j++)
                {
                    if (maze[i][j].getBottom())
                        System.out.print("|---");
                    else
                        System.out.print("|   ");
                }
                System.out.println("|");
            }
        }
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
        Q1Gen<String> solve = new Q1Gen<String>();
        String currentPosition, queuedPosition;
        String[] currentSplit = new String[2];
        int vertPos, horPos, rowLength, colLength;

        solve.add("0,0");
        rowLength = maze.length;
        colLength = maze[0].length;
        while (! solve.isEmpty()){
            currentPosition = solve.remove();
            currentSplit = currentPosition.split(",", 2);
            vertPos = Integer.parseInt(currentSplit[0]);
            horPos = Integer.parseInt(currentSplit[1]);
            maze[vertPos][horPos].setVisited(true);
            if (vertPos == rowLength - 1 && horPos == colLength - 1)
                break;

            //if the left cell is not visited and doesn't have a barrier, add to queue
            if (horPos - 1 >= 0 && horPos - 1 < colLength){
                if (! (maze[vertPos][horPos - 1].getRight() || maze[vertPos][horPos - 1].getVisited())){
                    horPos --;
                    queuedPosition = Integer.toString(vertPos) + "," + Integer.toString(horPos);
                    horPos ++;
                    solve.add(queuedPosition);
                }
            }

            //if the above cell is not visited and doesn't have a barrier, add to queue
            if (vertPos - 1 >= 0 && vertPos - 1 < rowLength){
                if (! (maze[vertPos - 1][horPos].getBottom() || maze[vertPos - 1][horPos].getVisited())){
                    vertPos --;
                    queuedPosition = Integer.toString(vertPos) + "," + Integer.toString(horPos);
                    vertPos ++;
                    solve.add(queuedPosition);
                }
            }

            //if the below cell is not visited and doesn't have a barrier, add to queue
            if (vertPos + 1 >= 0 && vertPos + 1 < rowLength){
                if (! (maze[vertPos][horPos].getBottom() || maze[vertPos + 1][horPos].getVisited())){
                    vertPos ++;
                    queuedPosition = Integer.toString(vertPos) + "," + Integer.toString(horPos);
                    vertPos --;
                    solve.add(queuedPosition);
                }
            }

            //if the right cell is not visited and doesn't have a barrier, add the right cell to queue
            if (horPos + 1 >= 0 && horPos + 1 < colLength){
                if (! (maze[vertPos][horPos].getRight() || maze[vertPos][horPos + 1].getVisited())){
                    horPos ++;
                    queuedPosition = Integer.toString(vertPos) + "," + Integer.toString(horPos);
                    horPos --;
                    solve.add(queuedPosition);
                }
            }
        }
        System.out.println("");
        System.out.println("Solving the maze, we get: ");
        System.out.println("");
        printMaze(true);
    }

    public static void main(String[] args){
        System.out.println("We have a 5 x 20 maze:");
        MyMaze maze = makeMaze(5,20);
        maze.printMaze(false);
        maze.solveMaze();
        System.out.println("We have a 15 x 10 maze:");
        maze = makeMaze(15,10);
        maze.printMaze(false);
        maze.solveMaze();
        System.out.println("We have a 6 x 6 maze:");
        maze = makeMaze(6,6);
        maze.printMaze(false);
        maze.solveMaze();
        System.out.println("We have a 1 x 1 maze:");
        maze = makeMaze(1,1);
        maze.printMaze(false);
        maze.solveMaze();
    }
}
