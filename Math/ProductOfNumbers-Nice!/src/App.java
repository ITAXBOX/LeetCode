import java.util.ArrayList;

class ProductOfNumbers {
    ArrayList<Integer> numbers;
    int product;

    public ProductOfNumbers() {
        numbers = new ArrayList<>();
        product = 1;
    }

    public void add(int num) {
        if (num == 0) {
            numbers = new ArrayList<>();
            product = 1;
        } else {
            product = product * num;
            numbers.add(product);
        }
    }

    public int getProduct(int k) {
        if (numbers.size() < k)
            return 0;

        int answer = numbers.get(numbers.size() - 1);

        if (numbers.size() == k)
            return answer;

        return answer / numbers.get(numbers.size() - 1 - k);
    }
}