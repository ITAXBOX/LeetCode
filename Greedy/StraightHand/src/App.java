import java.util.*;

public class App {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            if (countMap.get(num) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (countMap.getOrDefault(num + i, 0) > 0) {
                        countMap.put(num + i, countMap.get(num + i) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
