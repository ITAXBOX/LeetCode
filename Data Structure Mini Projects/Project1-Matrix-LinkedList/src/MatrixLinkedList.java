import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MatrixLinkedList {
    private MatrixNode head = null;
    private int rows, columns;

    private static class MatrixNode {

        int data;
        MatrixNode right, down;

        private MatrixNode(int data) {
            this.data = data;
            right = null;
            down = null;
        }

        private MatrixNode(int data, MatrixNode right, MatrixNode down) {
            this.data = data;
            this.right = right;
            this.down = down;
        }

        private MatrixNode(MatrixNode right, int data) {
            this.data = data;
            this.right = right;
            down = null;
        }

        private MatrixNode(int data, MatrixNode down) {
            this.data = data;
            this.right = null;
            this.down = down;
        }
    }

    void isEmpty() {
        if (head == null) {
            throw new NoSuchElementException("it is empty");
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public MatrixLinkedList(ArrayList<Integer>[] matrixData) {
        createMatrix(matrixData);
    }

    public void createMatrix(ArrayList<Integer>[] matrixData) {
        setColumns(matrixData[0].size());
        setRows(matrixData.length);
        if (rows == 0 || columns == 0) {
            throw new NoSuchElementException();
        }
        head = new MatrixNode(matrixData[0].get(0));
        MatrixNode dactylo = head;
        MatrixNode dummy = new MatrixNode(0, head);
        for (int i = 0; i < rows; i++) {
            MatrixNode tempNode = dummy;
            for (int j = 0; j < columns; j++) {
                if (j + 1 < columns && i == 0) {
                    dactylo.right = new MatrixNode(matrixData[i].get(j + 1));
                } else if (j + 1 < columns) {
                    dactylo.right = tempNode.right.down;
                    tempNode = tempNode.right;
                }
                if (i + 1 < rows) {
                    dactylo.down = new MatrixNode(matrixData[i + 1].get(j));
                }
                dactylo = dactylo.right;
            }
            dactylo = head;
            for (int j = 0; j <= i; j++) {
                dactylo = dactylo.down;
            }
            dummy = dummy.down;
        }
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        // First rowIndex=0
        isEmpty();
        if (rowIndex >= rows) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        MatrixNode dactylo = head;
        for (int i = 0; i < rowIndex; i++) {
            dactylo = dactylo.down;
        }
        while (dactylo != null) {
            ans.add(dactylo.data);
            dactylo = dactylo.right;
        }
        return ans;
    }

    public ArrayList<Integer> getColumn(int colIndex) {
        // First colIndex=0
        isEmpty();
        if (colIndex >= columns) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        MatrixNode dactylo = head;
        for (int i = 0; i < colIndex; i++) {
            dactylo = dactylo.right;
        }
        while (dactylo != null) {
            ans.add(dactylo.data);
            dactylo = dactylo.down;
        }
        return ans;
    }

    public int rowSum(int rowIndex) {
        isEmpty();
        if (rowIndex >= rows) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<Integer> temp = getRow(rowIndex);
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            sum += temp.get(i);
        }
        return sum;
    }

    public double columnAverage(int colIndex) {
        isEmpty();
        if (colIndex >= columns) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList<Integer> temp = getColumn(colIndex);
        double ans = 0;
        for (int i = 0; i < temp.size(); i++) {
            ans += temp.get(i);
        }
        return ans / temp.size();
    }

    public boolean find(int data) {
        isEmpty();
        return find(data, head);
    }

    private boolean find(int data, MatrixNode node) {
        // Recursive function
        if (node == null) {
            return false;
        }
        MatrixNode temp = node;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.right;
        }
        return find(data, node.down);
    }

    public void replaceData(int rowIndex, int colIndex, int newData) {
        isEmpty();
        if (rowIndex >= rows || colIndex >= columns) {
            throw new IndexOutOfBoundsException();
        }
        MatrixNode dactylo = head;
        for (int i = 0; i < rowIndex; i++) {
            dactylo = dactylo.down;
        }
        for (int i = 0; i < colIndex; i++) {
            dactylo = dactylo.right;
        }
        dactylo.data = newData;
    }

    public String toString() {
        isEmpty();
        String ans = "";
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> temp = getRow(i);
            for (int j = 0; j < columns; j++) {
                ans += temp.get(j) + " ";
            }
            ans += "\n";
        }
        return ans;
    }

    public void scalarMultiply(int scalar) {
        isEmpty();
        scalarMultiply(scalar, head);
    }

    private void scalarMultiply(int scalar, MatrixNode node) {
        // Recursive function
        if (node == null) {
            return;
        }
        MatrixNode temp = node;
        while (temp != null) {
            temp.data = temp.data * scalar;
            temp = temp.right;
        }
        scalarMultiply(scalar, node.down);
    }

    // Bonus Task
    public void add(MatrixLinkedList matrix) throws Exception {
        isEmpty();
        if (matrix.getColumns() != getColumns() || matrix.getRows() != getRows()) {
            throw new Exception("The sum cannot be made");
        }
        add(matrix, head, 0);
    }

    private void add(MatrixLinkedList matrix, MatrixNode node, int i) {
        // Recursive function
        if (node == null) {
            return;
        }
        MatrixNode temp = node;
        ArrayList<Integer> arr = matrix.getRow(i);
        int j = 0;
        while (temp != null) {
            temp.data = temp.data + arr.get(j);
            temp = temp.right;
            j++;
        }
        add(matrix, node.down, ++i);
    }
}
