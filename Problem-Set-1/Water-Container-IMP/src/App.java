public class App {
    public int maxArea(int[] height) {
        if (height.length == 0 || height == null)
            return 0;
        int max = 0, i = 0, j = height.length - 1;
        while (j > i) {
            int x = height[i], y = height[j];
            max = Math.max(max, Math.min(x, y) * (j - i));
            if (y > x) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
