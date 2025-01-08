import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static boolean BishopFormation(int n, char[][] board) {
        HashSet<Integer> Diagonals = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'b') {
                    int diagonal1 = i - j, diagonal2 = i + j;
                    if (Diagonals.contains(diagonal1) || Diagonals.contains(diagonal2)) {
                        return false;
                    }
                    Diagonals.add(diagonal1);
                    Diagonals.add(diagonal2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Please enter the number of lines:");
            int n = scan.nextInt();
            System.out.println("Please insert the ChessBoard:");
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = scan.next().charAt(0);
                }
            }
            if (BishopFormation(n, board))
                System.out.println("Valid");
            else {
                System.out.println("not Valid");
            }
        }
    }
}
