/*Conway's Game of Life
RULES
A point in the array of the gamespace is called a cell
The 3x3 area around the cell is considered the cell's neighbors
The game is run in "steps" or turns

In each step:
1.Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2.Any live cell with two or three live neighbours lives on to the next generation.
3.Any live cell with more than three live neighbours dies, as if by overpopulation.
4.Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

For this program, a constant, BOARD_SIZE, will be used for now and the cells that start alive will be determined by input
The board will be an array of cells represented by characters:
A * means Alive
A . means Dead

*/

import java.util.Scanner;

public class Game{

    static final int BOARD_SIZE = 15;
    static Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];
    public static void main(String args[]){
        initializeBoard();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many cells that you would like to start with: ");
        int input = sc.nextInt();
        
        int x;
        int y;
        int counter = 0;
        for(int i=0;i<input;i++){
            counter++;
            System.out.println("Enter the x and y seperated by a space of the " + counter + "th cell. Example: 1 2\n");
            x = sc.nextInt();
            y = sc.nextInt();
            board[y-1][x-1] = new Cell(true,y-1,x-1); 
        }
        displayBoard();

        while(true){
            controlTurn();
            performTurn();
            displayBoard();
            if(checkAll() == false){
                break;
            }
        }

        sc.close();
    }

    public static void initializeBoard(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                board[i][j] = new Cell(false,i,j);
            }
        }
    }

    public static void displayBoard(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                if (board[i][j].alive == false){
                    System.out.print(". ");
                } else{
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }


    public static void performTurn(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                    if(board[i][j].alive){
                        int neighbors = board[i][j].checkNeighbors(board);
                        if(neighbors != 2 && neighbors != 3){
                            board[i][j].alive = false;
                        } 

                    } else{
                        if(board[i][j].checkNeighbors(board) == 3){
                            board[i][j].alive = true;
                        }
                    }

            }
        }

    }

    public static void controlTurn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter for next turn");
        sc.nextLine();
    }

    public static Boolean checkAll(){
        for(int i=0;i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                if(board[i][j].alive){
                    return true;
                }
            }
        }
        return false;
    }

}
