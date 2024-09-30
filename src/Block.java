import java.util.*;

public class Block {

    public int[] solution(long begin, long end) {
        int[] answer = {};

        answer = updateBlockNumbers(1, begin, end);

        return answer;
    }

    public int[] updateBlockNumbers(int sourceNumber, long begin, long end) {
        int[] blockNumbers = {};

        // for (int i = sourceNumber; i <= end; i+sourceNumber) {
        //     blockNumbers[]
        // }


        if (sourceNumber >= 4) return blockNumbers;

        for (int idx = 1; idx < 4; idx++) {
            // updateBlockNumbers(idx);
        }

        return blockNumbers;
    }
}