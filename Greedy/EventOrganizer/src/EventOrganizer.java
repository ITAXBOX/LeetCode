import java.util.*;

class TimeList {
    Node head;

    class Node {
        double start, end;
        Node next;

        Node(double start, double end) {
            this(start, end, null);
        }

        Node(double start, double end, Node next) {
            this.start = start;
            this.end = end;
            this.next = next;
        }
    }

    public boolean add(double start, double end) {
        Node temp = head;
        while (temp != null) {
            if ((start >= temp.start && start < temp.end) || (end > temp.start && end <= temp.end)) {
                return false;
            }
            temp = temp.next;
        }
        head = new Node(start, end, head);
        return true;
    }
}

class House {
    ArrayList<TimeList> house = new ArrayList<>();

    House() {
        house.add(new TimeList());
    }

    public void Add(double start, double end) {
        Iterator<TimeList> itr = house.iterator();
        while (itr.hasNext()) {
            if (itr.next().add(start, end)) {
                return;
            }
        }
        TimeList newList = new TimeList();
        newList.add(start, end);
        house.add(newList);
    }
}

public class EventOrganizer {

    public static void main(String[] args) {
        House TheHouse = new House();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("WELCOME TO THE EVENT ORGANIZER:");
            System.out.println("Please enter the number of events:");
            int x = scan.nextInt();
            System.out.println("Please enter the times of the events in 24-hours format:");
            for (int i = 0; i < x; i++) {
                double startHour = scan.nextInt(), startMinutes = scan.nextInt() / 60.0,
                        endHour = scan.nextInt(), endMinutes = scan.nextInt() / 60.0;
                if ((startHour < 0 || startHour >= 24) || (endHour < 0 || endHour >= 24)
                        || (startMinutes < 0 || startMinutes >= 1) || (endMinutes < 0 || endMinutes >= 1)) {
                    System.out.println("Wrong input,Please enter the times of the events in 24-hours format:");
                    i--;
                    continue;
                } else {
                    TheHouse.Add(startHour + startMinutes, endHour + endMinutes);
                }
            }
        }
        System.out.println("Number of rooms required: " + TheHouse.house.size());
    }
}
