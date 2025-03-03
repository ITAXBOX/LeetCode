class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                answer[right--] = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                answer[left++] = nums[i];
            }
        }

        for (int i = left; i <= right; i++) {
            answer[i] = pivot;
        }

        return answer;
    }
}