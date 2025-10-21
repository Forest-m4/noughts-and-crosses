package game;
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
    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }
    public boolean isDraw() {
        return isFull() && !isWin('X') && !isWin('O');
    }
    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = mark;
        return true;
    }
    public void reset() {
        initBoard(); // переинициализируем поле
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
    public boolean isWin(char mark) {
        // строки
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != mark) { win = false; break; }
            }
            if (win) return true;
        }
        // столбцы
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != mark) { win = false; break; }
            }
            if (win) return true;
        }
        // диагональ 1
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != mark) { win = false; break; }
        }
        if (win) return true;
        // диагональ 2
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != mark) { win = false; break; }
        }
        if (win) return true;

        return false;
    }
}