import java.util.*;


public class RemoveParings {

    public int solution(String s) {
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        int result = stack.isEmpty() ? 1 : 0;

        return result;
    }
    
    public static void main(String[] args) {

        RemoveParings removeParings = new RemoveParings();
        int result = removeParings.solution("baabaa");

        System.out.println(result);
    }
}
