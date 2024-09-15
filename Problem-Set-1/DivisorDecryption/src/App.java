import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static List<Integer> findDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }
        divisors.remove(0);
        Collections.sort(divisors);
        return divisors;
    }

    public static String StringDecryption(String str, List<Integer> divisors) {
        char[] answer = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int counter = 0, index = i;
            while (counter != divisors.size()) {
                if (index <= divisors.get(counter) - 1) {
                    index = divisors.get(counter) - 1 - index;
                }
                counter++;
            }
            answer[index] = str.charAt(i);
        }
        return new String(answer);
    }

    public static void main(String[] args) {
        String str1 = "ctlubiedoc";
        System.out.println(StringDecryption(str1, findDivisors(str1.length())));//codeitclub

        String str2 = "mlaersredoc";
        System.out.println(StringDecryption(str2, findDivisors(str2.length())));// codersrealm
    }
}
