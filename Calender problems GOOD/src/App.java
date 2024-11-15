import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private ArrayList<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event : bookings) {
            int existingStart = event[0];
            int existingEnd = event[1];

            if (start < existingEnd && end > existingStart) {
                return false;
            }
        }
        bookings.add(new int[] { start, end });
        return true;
    }
}

class MyCalendarTwo {
    private List<int[]> single;
    private List<int[]> doubleBooked;

    public MyCalendarTwo() {
        single = new ArrayList<>();
        doubleBooked = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : doubleBooked) {
            if (Math.max(start, booking[0]) < Math.min(end, booking[1])) {
                return false;
            }
        }

        for (int[] booking : single) {
            if (Math.max(start, booking[0]) < Math.min(end, booking[1])) {
                doubleBooked.add(new int[] { Math.max(start, booking[0]), Math.min(end, booking[1]) });
            }
        }

        single.add(new int[] { start, end });
        return true;
    }
}