import java.math.BigInteger;

public class App {
    
    // Function to find the smallest multiple of n containing only ones
    public static BigInteger smallestMultiple(int n) {
        // Initialize a BigInteger with value 1
        BigInteger num = BigInteger.ONE;
        
        // Keep increasing the number until it is divisible by n
        while (!num.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
            // Append '1' to the existing number
            num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
        }
        
        return num;
    }
    
    public static void main(String[] args) {
        int n = 7; // Change this to your desired value of n
        BigInteger result = smallestMultiple(n);
        System.out.println("The smallest number containing only ones that is a multiple of " + n + " is: " + result);
        System.out.println("Number of digits: " + result.toString().length());
    }
}
