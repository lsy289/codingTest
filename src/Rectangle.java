import java.util.*;

public class Rectangle {
    
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> x_countMap = new HashMap<>();
        Map<Integer, Integer> y_countMap = new HashMap<>();
        for(int[] dot : v) {
            int x_element = dot[0];
            int y_element = dot[1];
            x_countMap.put(x_element, x_countMap.getOrDefault(x_element, 0) + 1);
            y_countMap.put(y_element, y_countMap.getOrDefault(y_element, 0) + 1);
        }

        for(int[] dot2 : v) {
            if (x_countMap.get(dot2[0]) == 1) {
                answer[0] = dot2[0];
            }
            
            if (y_countMap.get(dot2[1]) == 1) {
                answer[1] = dot2[1];
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        
        int[] result = Rectangle.solution(new int[][] {{1,4}, {3,4}, {3,10}});
        System.out.println(Arrays.toString(result));
        
    }
}
