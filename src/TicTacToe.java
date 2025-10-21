
public class TicTacToe {
    private char[][] board;
    private int size;

    public TicTacToe(int size) {
        this.size = size;
        board = new char[size][size];
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = mark;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j]);
                if (j < size - 1) System.out.print(" |");
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }
}