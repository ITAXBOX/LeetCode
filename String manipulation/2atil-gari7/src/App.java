import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Please enter the codeMaker and the codeBreaker: ");
            String codeMaker = scan.next(), codeBreaker = scan.next();
            int correctPosition = 0, wrongPosition = 0;
            HashMap<Character, Integer> codeMakerHashMap = new HashMap<>();
            for (int i = 0; i < codeMaker.length(); i++) {
                char maker = codeMaker.charAt(i), breaker = codeBreaker.charAt(i);
                if (maker == breaker) {
                    correctPosition++;
                } else {
                    codeMakerHashMap.put(maker, codeMakerHashMap.getOrDefault(maker, 0) + 1);
                    if (codeMakerHashMap.get(maker) <= 0)
                        wrongPosition++;
                    codeMakerHashMap.put(breaker, codeMakerHashMap.getOrDefault(breaker, 0) - 1);
                    if (codeMakerHashMap.get(breaker) >= 0)
                        wrongPosition++;
                }
            }
            System.out.println(correctPosition + " " + wrongPosition);
        }
    }
}