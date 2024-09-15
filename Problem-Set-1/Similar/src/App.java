import java.util.*;

public class App {
    public static void similar(Deque<Integer> a, Deque<Integer> b) {
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> ans1 = new LinkedList<>();
        ans1.addAll(b);
        ans1.addAll(a);
        set.addAll(b);
        Iterator<Integer> itr = ans1.iterator();
        while (itr.hasNext()) {
            Integer temp = itr.next();
            if (set.contains(temp)) {
                itr.remove();
            }
        }
        HashSet<Integer> set2 = new HashSet<>();
        Deque<Integer> ans2 = new LinkedList<>();
        ans2.addAll(b);
        ans2.addAll(a);
        set2.addAll(a);
        Iterator<Integer> itr2 = ans2.iterator();
        while (itr2.hasNext()) {
            Integer temp = itr2.next();
            if (set2.contains(temp)) {
                itr2.remove();
            }
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }

    public static void main(String[] args) {
        Deque<Integer> obj1 = new ArrayDeque<Integer>();
        obj1.push(4);
        obj1.push(9);
        obj1.push(6);
        obj1.push(4);
        obj1.push(2);
        Deque<Integer> obj12 = new ArrayDeque<Integer>();
        obj12.push(9);
        obj12.push(2);
        obj12.push(0);
        obj12.push(2);
        obj12.push(7);
        obj12.push(3);
        similar(obj1, obj12);
        System.out.println(obj1);
        System.out.println(obj12);
    }
}
