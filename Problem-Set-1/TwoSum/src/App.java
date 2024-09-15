import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4 }, 7)));//[3,4]
    }
}
