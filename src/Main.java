import game.TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        Scanner scanner = new Scanner(System.in);
        char current = 'X';

        while (true) {
            System.out.println();
            game.printBoard();
            System.out.println("Ход игрока " + current + ". Введите: row col (0-based) или 'r' для рестарта или 'q' для выхода:");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Выход.");
                break;
            }
            if (line.equalsIgnoreCase("r")) {
                game.reset();
                current = 'X';
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Неверный ввод. Попробуй: 0 2");
                continue;
            }
            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                if (!game.placeMark(row, col, current)) {
                    System.out.println("Нельзя поставить туда. Попробуй ещё.");
                    continue;
                }
                // проверка победы
                if (game.isWin(current)) {
                    game.printBoard();
                    System.out.println("Игрок " + current + " победил!");
                    System.out.println("Введите 'r' чтобы рестарт, или 'q' чтобы выйти.");
                    String cmd = scanner.nextLine().trim();
                    if (cmd.equalsIgnoreCase("r")) {
                        game.reset();
                        current = 'X';
                        continue;
                    } else {
                        break;
                    }
                }
                // проверка ничьи
                if (game.isDraw()) {
                    game.printBoard();
                    System.out.println("Ничья!");
                    System.out.println("Введите 'r' чтобы рестарт, или 'q' чтобы выйти.");
                    String cmd = scanner.nextLine().trim();
                    if (cmd.equalsIgnoreCase("r")) {
                        game.reset();
                        current = 'X';
                        continue;
                    } else {
                        break;
                    }
                }

                // смена игрока
                current = (current == 'X') ? 'O' : 'X';
            } catch (NumberFormatException e) {
                System.out.println("Ошибка парсинга. Попробуй ещё.");
            }
        }
        scanner.close();
    }
}