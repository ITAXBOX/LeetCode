import java.util.Stack;

public class App {
    static class Move {
        int n;
        char source, auxiliary, destination;

        Move(int n, char source, char auxiliary, char destination) {
            this.n = n;
            this.source = source;
            this.auxiliary = auxiliary;
            this.destination = destination;
        }
    }

    public static void Better_towerOfHanoi(int n, char source, char auxiliary, char destination) {// ITERATIVE
        Stack<Move> moves = new Stack<>();
        moves.push(new Move(n, source, auxiliary, destination));

        while (!moves.isEmpty()) {
            Move move = moves.pop();
            if (move.n == 1) {
                System.out.println("Move disk 1 from rod " + move.source + " to rod " + move.destination);
            } else {
                moves.push(new Move(move.n - 1, move.auxiliary, move.source, move.destination));
                moves.push(new Move(1, move.source, move.auxiliary, move.destination));
                moves.push(new Move(move.n - 1, move.source, move.destination, move.auxiliary));
            }
        }
    }// Same time complexity-->2^(n)-1 but better space complexity-->n

    public static void towerOfHanoi(int n, char source, char destination, char between) {// RECURSION
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, between, destination);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
        towerOfHanoi(n - 1, between, destination, source);
    }

    public static void main(String args[]) {
        int n = 5;
        Better_towerOfHanoi(n, 'A', 'B', 'C');
    }
}
