import java.util.Arrays;

public class App {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // Find the maximum number to know the number of digits
        int max = getMax(nums);

        // Do counting sort for every digit. Note that instead of passing digit number,
        // exp is passed.
        // exp is 10^i where i is the current digit number.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, exp);
        }

        return nums;
    }

    // A utility function to get the maximum value in the array
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // A function to do counting sort of nums[] according to the digit represented
    // by exp
    private void countSort(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(nums[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit
        // in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        // Copy the output array to nums[], so that nums[] now contains sorted numbers
        // according to the current digit
        for (int i = 0; i < n; i++) {
            nums[i] = output[i];
        }
    }
}