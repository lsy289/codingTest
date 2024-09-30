import java.util.Arrays;

public class Carpet {
    
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;  // 카펫의 전체 격자 수
        
        // 전체 면적의 약수들을 확인
        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {  // 나누어 떨어지면 가로를 구할 수 있음
                int width = total / height;
                
                // 조건: 노란색 격자 수가 맞는지 확인
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        
        return new int[0];  // 조건을 만족하는 경우가 없으면 빈 배열 반환

    }

    public static void main(String[] args) {
        Carpet sol = new Carpet();
        // int[] result1 = sol.solution(10, 2);  // [4, 3]
        // System.out.println(Arrays.toString(result1));

        // int[] result2 = sol.solution(8, 1);  // [3, 3]
        // System.out.println(Arrays.toString(result2));

        int[] result3 = sol.solution(24, 24);  // [8, 6]
        System.out.println(Arrays.toString(result3));
    }
}
