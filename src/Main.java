import game.TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Демонстрация restart:");
        game.printBoard();

        // делаем пару ходов вручную в demo
        game.placeMark(0,0,'X');
        game.placeMark(1,1,'O');
        System.out.println("После нескольких ходов:");
        game.printBoard();

        System.out.println("Делаем reset...");
        game.reset();
        game.printBoard();

        System.out.println("Заполняем поле для демонстрации ничьи:");
        int mark = 0;
        char[] chars = {'X','O'};
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                game.placeMark(i,j,chars[mark%2]);
                mark++;
            }
        }
        game.printBoard();
        System.out.println("isDraw = " + game.isDraw());
    }
}