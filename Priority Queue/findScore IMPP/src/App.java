import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(new int[] { nums[i], i });
        }

        long score = 0;
        HashSet<Integer> indexBlackList = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            int[] num = priorityQueue.poll();

            if (!indexBlackList.contains(num[1])) {
                score += num[0];
                indexBlackList.add(num[1]);
                indexBlackList.add(num[1] - 1);
                indexBlackList.add(num[1] + 1);
            }
        }

        return score;
    }
}