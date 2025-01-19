import java.util.*;

public class App {
    // Input: people = [5,4,3,1,1], limit = 5
    // Output: 3
    // Explanation: (5),(4,1),(3,1)

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0, left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }

}