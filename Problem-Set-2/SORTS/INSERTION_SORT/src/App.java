import java.util.ArrayList;

class InsertionSort {
    public static void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;

            // Move elements of list[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(11);
        list.add(13);
        list.add(5);
        list.add(6);

        System.out.println("Before Sorting: " + list);
        insertionSort(list);
        System.out.println("After Sorting: " + list);
    }
}
