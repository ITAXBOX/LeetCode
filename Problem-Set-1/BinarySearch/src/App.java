public class App {
    //nums = [1,3,4,5,6], target = 2    nums = [1,3,5,6], target = 5
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (right >= left) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,4,5,6}, 2));
    }
}
