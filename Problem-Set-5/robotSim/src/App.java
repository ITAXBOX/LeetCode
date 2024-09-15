import java.util.HashSet;

class Solution {
    private static int[][] directionVectors = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static int robotSim(int[] commands, int[][] obstacles) {
        int furthestDistance = 0;

        int direction = 0;
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();

        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + directionVectors[direction][0];
                    int newY = y + directionVectors[direction][1];

                    if (set.contains(newX + "," + newY)) {
                        break;
                    }

                    x = newX;
                    y = newY;
                }
            }
            furthestDistance = Math.max(furthestDistance, x * x + y * y);
        }

        return furthestDistance;
    }
}