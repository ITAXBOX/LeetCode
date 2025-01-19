public class App {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        char charr[] = n.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            if (max < charr[i] - '0')
                max = charr[i] - '0';
        }
        return max;
    }
}
