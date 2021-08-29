/*
Class defining the cell object, each cell will be represented on the board and just simply be alive or dead. Coordinates need to be stored too

*/

public class Cell{
    Boolean alive;
    //Gives the cell coordinates via the coordinate class
    Coordinates location;

    public Cell(Boolean alive,int xCord, int yCord){
        this.alive = alive;
        location = new Coordinates(xCord,yCord);
    }

    //Returns the number of alive neighbors relative to the cell
    public int checkNeighbors(Cell[][] board){
        int numAlive = 0;
        if(this.location.x != 0 && board[this.location.x - 1][this.location.y].alive){
            numAlive++;
        }

        if(this.location.y != 0 && board[this.location.x][this.location.y - 1].alive){
            numAlive++;
        }

        if(this.location.x != 0 && this.location.y != 0 && board[this.location.x-1][this.location.y-1].alive){
            numAlive++;
        }

        if(this.location.x != board.length-1 && board[this.location.x+1][this.location.y].alive){
            numAlive++;
        }

        if(this.location.y != board.length-1 && board[this.location.x][this.location.y+1].alive){
            numAlive++;
        }

        if(this.location.y != board.length-1 && this.location.x != board.length-1 && board[this.location.x+1][this.location.y+1].alive){
            numAlive++;
        }

        if(this.location.x != board.length-1 && this.location.y != 0 && board[this.location.x+1][this.location.y-1].alive){
            numAlive++;
        }

        if(this.location.x != 0 && this.location.y != board.length-1 && board[this.location.x-1][this.location.y+1].alive){
            numAlive++;
        }
        
        return numAlive;
    }


}