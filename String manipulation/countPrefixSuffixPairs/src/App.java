class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = words[i];
            int strLength = str.length();

            for (int j = i + 1; j < n; j++) {
                String word = words[j];

                if (word.length() >= strLength) {
                    if (word.startsWith(str) && word.endsWith(str)) { // we can use many functions like starwith
                        answer++;                                     // endwith and contains and substring
                    }
                }
            }
        }

        return answer;
    }
}