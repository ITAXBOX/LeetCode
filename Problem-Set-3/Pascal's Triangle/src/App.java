import java.util.*;

public class App {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] num = new Integer[i + 1];
            for (int j = 0; j < num.length; j++) {
                if (j == 0 || j == num.length - 1)
                    num[j] = 1;
                else {
                    List<Integer> temp = answer.get(i - 1);
                    num[j] = temp.get(j - 1) + temp.get(j);
                }
            }
            answer.add(new ArrayList<>(Arrays.asList(num)));
        }
        return answer;
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        long ans = 1;
        List<Integer> newList = new ArrayList<Integer>();
        newList.add((int) ans);
        for (int colIndex = 1; colIndex < rowIndex; colIndex++) {
            ans = ans * (rowIndex - colIndex) / colIndex;
            newList.add((int) ans);
        }
        return newList;
    }
}
