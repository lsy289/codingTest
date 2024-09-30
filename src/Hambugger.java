import java.util.*;

public class Hambugger {

    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int buggerCount = 0;

        for (int element : ingredient) {
            stack.push(element);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 1) == 1 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 4) == 1
                ) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    buggerCount += 1;
                }
            }
        }

        return buggerCount;
    }


    public static void main(String[] args) {
        Hambugger hambugger = new Hambugger();

        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        int result = hambugger.solution(ingredient);
        System.out.println(result);
    }

}