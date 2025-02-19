class Solution {
    int counter = 0;
    boolean stop = false;
    char[] characters = { 'a', 'b', 'c' };
    String answer = "";

    public String getHappyString(int n, int k) {
        backtracking("", n, k, 0);
        return answer;
    }

    private void backtracking(String temp, int n, int k, int i) {
        if (stop)
            return;
        if (i == n) {
            counter++;
            if (counter == k)
                answer = temp;
            if (counter >= k)
                stop = true;
        } else {
            for (int j = 0; j < characters.length; j++) {
                if (temp.equals("") ||
                        temp.charAt(temp.length() - 1) != characters[j]) {
                    backtracking(String.valueOf(temp + characters[j]), n, k, i + 1);
                }
            }
        }
    }
}