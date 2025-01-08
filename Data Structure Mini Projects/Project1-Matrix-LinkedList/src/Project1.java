import java.util.ArrayList;
import java.util.Arrays;

public class Project1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>[] temp = new ArrayList[] {
                new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                new ArrayList<>(Arrays.asList(1, 2, 8, 88)),
                new ArrayList<>(Arrays.asList(1, 22, 3, 10))
        };
        MatrixLinkedList obj1 = new MatrixLinkedList(temp);
        System.out.println(obj1);
        System.out.println(obj1.getRow(0));// [1,2,3,4]
        System.out.println(obj1.getColumn(0));// [1,1,1]
        System.out.println(obj1.rowSum(1));// 99
        System.out.println(obj1.columnAverage(3));// 34.0
        System.out.println(obj1.find(1000));// false
        obj1.replaceData(0, 0, 2);
        System.out.println(obj1);
        obj1.scalarMultiply(4);
        System.out.println(obj1);

        ArrayList<Integer>[] temp2 = new ArrayList[] {
                new ArrayList<>(Arrays.asList(11, 12, 13, 14)),
                new ArrayList<>(Arrays.asList(11, 12, 18, 188)),
                new ArrayList<>(Arrays.asList(11, 122, 13, 110))
        };
        MatrixLinkedList obj2 = new MatrixLinkedList(temp2);
        System.out.println(obj2);

        obj1.add(obj2);
        System.out.println(obj1);
    }
}
