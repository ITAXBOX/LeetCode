public class App {
    public int maxPoints(int[][] points) {
        if (points.length == 1)
            return 1;
        int answer = 2;
        for (int index = 0; index < points.length - 1; index++) {
            for (int i = index + 1; i < points.length; i++) {
                int xFirst = points[index][0], yFirst = points[index][1];
                int xSecond = points[i][0], ySecond = points[i][1];
                int result = 2;
                int xDifference = xFirst - xSecond;
                int yDifference = yFirst - ySecond;
                for (int j = i + 1; j < points.length; j++) {
                    int xThird = points[j][0], yThird = points[j][1];
                    if (xDifference == 0) {
                        if (points[j][0] == xFirst)
                            result++;
                    } else if (yDifference == 0) {
                        if (points[j][1] == yFirst)
                            result++;
                    } else if ((yThird - yFirst) * xDifference == (xThird - xFirst) * yDifference) {
                        result++;
                    }
                }
                answer = Math.max(answer, result);
                if (answer == points.length)
                    return points.length;
            }
        }
        return answer;
    }

}
