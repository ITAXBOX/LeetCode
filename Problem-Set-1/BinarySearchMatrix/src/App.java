public class App {
    public static boolean MatrixSearch(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, index = -1;
        while (left <= right) {
            int midd = (left + right) / 2;
            if (matrix[midd][matrix[midd].length - 1] == target) {
                return true;
            } else if (matrix[midd][matrix[midd].length - 1] > target) {
                right = midd - 1;
                index = midd;
            } else {
                left = midd + 1;
            }
        }
        if (index == -1)
            return false;
        else {
            return BinarySearch(matrix[index], target);
        }
    }

    public static boolean BinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(MatrixSearch(new int[][] { { 1, 2, 3 }, { 6, 7, 8 }, { 10, 11, 12 } }, 9));
    }
}
