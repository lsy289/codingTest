import java.util.*;

public class Jelly {

    public static int solution(int score) {
        int answer = 0;

        int rainbow = 100, star = 50, yellow = 5, normal = 1;
        int remainder = score;

        answer += Math.floorDiv(remainder, rainbow);
        remainder = remainder % rainbow;
        
        answer += Math.floorDiv(remainder, star);
        remainder = remainder % star;

        answer += Math.floorDiv(remainder, yellow);
        remainder = remainder % yellow;

        answer += Math.floorDiv(remainder, normal);
        remainder = remainder % normal;

        return answer;
    }

    public static void main(String[] args) {
        
        int result = Jelly.solution(551);
        System.out.println(result);

    }
    
}
