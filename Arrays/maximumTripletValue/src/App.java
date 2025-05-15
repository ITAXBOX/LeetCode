class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            long a = nums[i];
            for (int j = i + 1; j < n; j++) {
                long b = a - nums[j];
                if (b > 0) {
                    for (int k = j + 1; k < n; k++) {
                        answer = Math.max(answer, b * nums[k]);
                    }
                }
            }
        }

        return answer;
    }

    // O(n)
    public long maximumTripletValueBest(int[] nums) {
        long maxTriplet = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxElement - num);
            maxElement = Math.max(maxElement, num);
        }
        return maxTriplet;
    }
}