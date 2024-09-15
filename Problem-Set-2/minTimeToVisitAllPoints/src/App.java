
public class App {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1)
            return 0;
        int x = points[0][0], y = points[0][1], answer = 0;
        for (int i = 1; i < points.length; i++) {
            int xDest = points[i][0], yDest = points[i][1];
            int xDifference = Math.abs(x - xDest), yDifference = Math.abs(y - yDest);
            answer += Math.max(xDifference, yDifference);
            x = xDest;
            y = yDest;
        }
        return answer;
    }

}
