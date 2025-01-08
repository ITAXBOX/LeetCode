public class App {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int Abit;
            int Bbit;
            if (i >= 0) {
                Abit = a.charAt(i) - '0';
                i--;
            } else {
                Abit = 0;
            }
            if (j >= 0) {
                Bbit = b.charAt(j) - '0';
                j--;
            } else {
                Bbit = 0;
            }
            int sum = Abit + Bbit + carry;
            carry = sum / 2;
            ans.insert(0, sum % 2);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10", "11"));
    }
}
