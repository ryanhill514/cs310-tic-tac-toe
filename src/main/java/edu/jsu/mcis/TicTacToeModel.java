package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
		grid = new Mark[width][width];
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        for(int i=0; i<width; i++){
            for(int j=0; j<width; j++){
              grid[i][j] = Mark.EMPTY;  
            }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		if(isValidSquare(row,col)==true && !isSquareMarked(row,col) && xTurn == true){
            grid[row][col]= Mark.X;
            xTurn =false;
        }
        if(isValidSquare(row,col)==true && !isSquareMarked(row,col) && xTurn == false){
            grid[row][col] = Mark.O;
            xTurn = true;
        }
            return true;
        //return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		if((row>=0 || row<width) && (col>=0 || col<width)){
            return true;
        }
        else{
            return false; /* remove this line! */
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */

        return false; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		Mark mark = grid[row][col];
        
        return mark;
        //return null; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		if(isMarkWin(Mark.X)){
            return Result.X;
        }
        else if(isMarkWin(Mark.O)){
            return Result.O;
        }
        else if(isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }
        //return null; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		 // Check win by a row--------------------------------------------------
        int counter=0;
        for(int i = 0; i < width; i++){
          for(int j = 0; j < width; j++){
            if(grid[i][j] == mark){
                counter++;
            }
            if(counter == (width)){
                return true;
            }
          }
          counter=0;
        }
        // End check win by row-------------------------------------------------
        
        // Check win by a column------------------------------------------------
        for(int j = 0; j < width; j++){
          for(int i = 0; i < width; i++){
            if(grid[i][j] == mark){
                counter++;
            }
            if(counter == (width)){
                return true;
            }
          }
          counter=0;
        }
        // End check win by column----------------------------------------------

        // Check win by a diagonal (1)(TL -> BR)--------------------------------
        for(int i = 0; i < width; i++){
          if(grid[i][i] == mark){
              counter++;
          }
          if(counter == width){
              return true;
          }
        }
        counter=0;
        //End check win by diagonal (1)(TL -> BR)-------------------------------
        
        // Check win by a diagonal (2)(TR -> BL)--------------------------------
        for(int i = 0; i < width; i++){
          if(grid[i][(width-1) - i] == mark){
            counter++;
          }
          if(counter == width){
              return true;
          }
          
        }
        counter=0;
        return false; /* remove this line! */
       //End check win by diagonal (2)(TR -> BL)--------------------------------
    }
	
    private boolean isTie() {
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        
        // Check tie by a row
        for(int i = 0; i < width; i++){
          for(int j = 0; j < width; j++){
            if(getMark(i,j) == Mark.EMPTY){
                return false;
            } 
          }
        }
        //return false; /* remove this line! */
        if(isMarkWin(Mark.X) || isMarkWin(Mark.O)){
              return false;
        }
        else{
            return true;
        }
    }

    public boolean isGameover() {
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
}