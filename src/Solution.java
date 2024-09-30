import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class SubsequenceRemoval {

    /*
     * Complete the 'findSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> results = new ArrayList<>();
        
        for (String command : commands) {
            if (isCircle(command)) {
                results.add("YES");
            } else {
                results.add("NO");
            }
        }
        
        return results;
    }
    
    private static boolean isCircle(String command) {
        int x = 0, y = 0;
        int direction = 0;  // 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽

        for (char c : command.toCharArray()) {
            if (c == 'G') {
                // 로봇을 현재 방향으로 이동
                if (direction == 0) y++;  // 북쪽
                else if (direction == 1) x++;  // 동쪽
                else if (direction == 2) y--;  // 남쪽
                else if (direction == 3) x--;  // 서쪽
            } else if (c == 'L') {
                // 왼쪽으로 90도 회전
                direction = (direction + 3) % 4;
            } else if (c == 'R') {
                // 오른쪽으로 90도 회전
                direction = (direction + 1) % 4;
            }
        }
        
        // 한 번의 명령어 수행 후, 로봇이 (0, 0)에 있거나 방향이 바뀌었으면 원 안에 남음
        return (x == 0 && y == 0) || (direction != 0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> result = SubsequenceRemoval.doesCircleExist(
            Arrays.asList("3", "G", "L", "RGRG")
        );

        System.out.println(result);
    }
}
