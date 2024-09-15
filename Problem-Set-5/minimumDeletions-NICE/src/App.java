class SubrectangleQueries {
    public int minimumDeletions(String s) {
        int answer = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b')
                count++;
            else if (count != 0) {
                answer++;
                count--;
            }
        }
        return answer;
    }
}