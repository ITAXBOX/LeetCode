class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] answer = new String[words.length];

        for (String str : words) {
            answer[str.charAt(str.length() - 1) - '0' - 1] = str.substring(0, str.length() - 1);
        }

        return String.join(" ", answer); // Very Useful Method
    }
}