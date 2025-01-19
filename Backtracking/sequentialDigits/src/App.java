import java.util.*;

public class App {
    public List<Integer> sequentialDigits(int low, int high) {
        List<String> seq = new ArrayList<>();
        for (int startNum = 1; startNum < 9; startNum++) {
            formseq("", startNum, seq);
        }
        List<Long> nums = new ArrayList<>();

        for (String num : seq) {
            long currNum = Long.parseLong(num);
            if (currNum >= low && currNum <= high)
                nums.add(currNum);
        }
        Collections.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (long num : nums)
            res.add((int) num);
        return res;
    }

    private void formseq(String num, int currDig, List<String> seq) {
        if (currDig == 10) {
            seq.add(num);
            return;
        }
        if (!num.isEmpty())
            seq.add(num);
        num += Integer.toString(currDig);
        formseq(num, currDig + 1, seq);
    }
}
