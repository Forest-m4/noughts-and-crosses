import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        Scanner scanner = new Scanner(System.in);

        game.printBoard();
        System.out.println("Нач версия: поле создано. Добавлю фичи в отдельных ветках.");
    }
}