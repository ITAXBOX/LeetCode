import java.util.Arrays;
import java.util.Comparator;

public class App implements Comparator<String> {
    public static String largestNumber(int[] nums) {
        String[] stringArray = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(stringArray, new App());
        if (stringArray[0].equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            ans.append(stringArray[i]);
        }
        return ans.toString();
    }

    @Override
    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }
}
