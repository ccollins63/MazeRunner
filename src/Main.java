import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //sets the maze to be navigated (default maze is in MazeLoader)
        Maze maze1       = new Maze(MazeLoader.manualMaze());
        String userInput = "";
        Scanner input    = new Scanner(System.in);

        //File subsection
        //check if there is a .txt file named "maze.txt" to use. If not, use the manual maze.
        File mazeFile = new File("maze.txt");
        if (mazeFile.exists()){
            //set Scanner to mazeFile. It should be handled
            try {
                Scanner inputMaze = new Scanner(mazeFile);
            }

            catch (FileNotFoundException ex){
                System.out.println("File not found.");
            }

            //catch (MazeLoadException ex){

            //}
        }


        //set while loop to run until the maze is finished, or the user quits
        while ((!maze1.isFinished()) && (!userInput.equals("quit")))
        {
            if (maze1.isFirstTime())
            {
                maze1.displayFirstTime();
                maze1.displayMaze();
            }

            //get input
            System.out.println("Type\n\"Step\" to continue:\n\"Find\" to proceed to end result:\n\"Quit\" to exit:\n");
            userInput = input.next().toLowerCase();

            //check for validity
            while ((!userInput.equals("step") && (!userInput.equals("find") && (!userInput.equals("quit")))))
            {
                System.out.println("Invalid input detected. Type\n\"Step\" to continue:\n\"Find\" to proceed to end result:\n\"Quit\" to exit:\n");
                userInput = input.next().toLowerCase();
            }

            //check for quit message
            if (userInput.equals("quit"))
            {
                break;
            }

            //determine input
            switch (userInput)
            {
                case "step":
                {
                    maze1.takeStep();
                    maze1.displayMaze();
                    break;
                }

                case "find":
                {
                    maze1.findExit();
                    maze1.displayMaze();
                    break;
                }
            }
        }

        System.out.println("Finished.");
    }
}
