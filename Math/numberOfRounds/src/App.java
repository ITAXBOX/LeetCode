public class App {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = toMinutes(loginTime), end = toMinutes(logoutTime);

        int roundedStart = toNextQuarter(start);
        int roundedEnd = toPreviousQuarter(end);

        if (start < end) {
            return Math.max(0, (roundedEnd - roundedStart) / 15);
        }

        return (24 * 60 - roundedStart + roundedEnd) / 15;
    }

    public static int toMinutes(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60
                + Integer.parseInt(s.substring(3, 5));
    }

    public static int toNextQuarter(int time) {
        return ((time + 14) / 15) * 15;
    }

    public static int toPreviousQuarter(int time) {
        return (time / 15) * 15;
    }
}
