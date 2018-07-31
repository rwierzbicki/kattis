

/**
 * Class that represents a Boggle board and enables a recursive search
 * of that board.
 *   @author Dave Reed
 *   @version 11/3/07
 */
public class boggle {
    private final static int SIZE = 4;
    private char[][] board;
            
    /**
     * Constructs a Boggle board with random letters in each spot.
     * <br />Note: assumes that the dictionary of legal words is stored
     *       in a file named "dictionary.txt"
     */
    public boggle() {
        this.board = new char[boggle.SIZE][boggle.SIZE];
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board.length; c++) {
                this.board[r][c] = (char)('a' + (int)(Math.random()*26));
            }
        }
    }
    
    /**
     * Determines whether word can be found on the Boggle board.
     *   @param word the word to be searched for
     *   @return true if found; else false
     */
    public boolean findWord(String word) {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board.length; col++) {
                if (this.findWord(word, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Helper function for findWord, uses recursive backtracking
     */
    private boolean findWord(String word, int row, int col) {
        if (word.equals("")) {
            return true;
        }
        else if (row < 0 || row >= this.board.length || 
                 col < 0 || col >= this.board.length || 
                 this.board[row][col] != word.charAt(0)) {
            return false;
        }
        else {
            char safe = this.board[row][col];
            this.board[row][col] = '*';
            String word = rest.substring(1, word.length());
            boolean result = this.findWord(rest, row-1, col-1) ||
                             this.findWord(rest, row-1,   col) ||
                             this.findWord(rest, row-1, col+1) ||
                             this.findWord(rest,   row, col-1) ||
                             this.findWord(rest,   row, col+1) ||
                             this.findWord(rest, row+1, col-1) ||
                             this.findWord(rest, row+1,   col) ||
                             this.findWord(rest, row+1, col+1);
            this.board[row][col] = safe;
            return result;
        }
    }
    
    /**
     * Converts the board to a String (with line breaks after each row)
     *   @return the string version of the board
     */
    public String toString() {
        String str = "";
        for (int r = 0; r < board.length; r++) {
            for (char ch : board[r]) {
                str += ch + " ";
            }
            if (r < board.length-1) { 
                str += "\n"; 
            }
        }
        return str;
    }
}
