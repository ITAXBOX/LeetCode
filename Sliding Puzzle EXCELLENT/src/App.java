import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        String finalString = "123450";
        StringBuilder startState = new StringBuilder("");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                startState.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startState.toString());
        int moves = 0;
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                String currState = queue.poll();
                if (currState.equals(finalString)) {
                    return moves;
                }
                int zeroIdx = currState.indexOf('0');
                for (int newIdx : directions[zeroIdx]) {
                    String nextState = swap(currState, zeroIdx, newIdx);
                    if (visited.contains(nextState)) {
                        continue;
                    }
                    queue.add(nextState);
                    visited.add(nextState);
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String state, int i, int j) {
        StringBuilder s = new StringBuilder(state);
        s.setCharAt(i, state.charAt(j));
        s.setCharAt(j, state.charAt(i));
        return s.toString();
    }
}