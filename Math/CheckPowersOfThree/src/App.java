class Solution {
    public boolean checkPowersOfThree(int n) {
        return !Integer.toString(n, 3).contains("2");
    }

    public boolean checkPowersOfB(int n, int b) {// b>=2
        return !Integer.toString(n, b).matches(".*[2-" + (b - 1) + "].*");
    }
}