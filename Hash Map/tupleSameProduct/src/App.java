import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        int answer = 0, n = nums.length;
        Map<Integer, Integer> products = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                answer += products.getOrDefault(prod, 0);
                products.put(prod, products.getOrDefault(prod, 0) + 1);
            }
        }
        return answer * 8;
    }
}