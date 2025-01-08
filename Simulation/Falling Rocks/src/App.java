
public class App {
    public static int FallingRocks(Character[][] matrix) {
        int i = 0, j = 0, NumberOfRocks = 0;
        outerloop: for (j = 0; j < matrix.length; j++) {
            for (i = 0; i < matrix[0].length; i++) {
                if (matrix[j][i] == '+')
                    break outerloop;
            }
        }
        if (j == matrix.length - 1)
            return NumberOfRocks;
        while (true) {
            int k = i;
            try {
                for (int x = j + 1; x < matrix.length; x++) {
                    if (matrix[x][k] == '#' || matrix[x][k] == 'O') {
                        if (matrix[x][k - 1] == '.')
                            k--;
                        else if (matrix[x][k + 1] == '.')
                            k++;
                        else {
                            matrix[x - 1][k] = 'O';
                            break;
                        }
                    }
                    if (x == matrix.length - 1 && matrix[x][k] == '.') {
                        return NumberOfRocks;
                    }
                }
                NumberOfRocks++;
            } catch (IndexOutOfBoundsException e) {
                return NumberOfRocks;
            }
        }
    }

    public static void main(String[] args) {
        Character[][] matrix = new Character[][] { { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '#', '.', '.', '.', '#', '#' },
                { '.', '.', '.', '.', '#', '.', '.', '.', '#', '.' },
                { '.', '.', '#', '#', '#', '.', '.', '.', '#', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '#', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '#', '.' },
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '.' } };
        System.out.println(FallingRocks(matrix));
    }
}
