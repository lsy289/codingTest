public class jumpAndmoving {
    
    public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            // N이 홀수일 때는 1칸 점프가 필요하므로 건전지 사용량을 증가시킴
            if (n % 2 == 1) {
                answer++;
                n--;  // 점프 후 N을 1 감소시킴
            }
            // N이 짝수일 때는 순간이동이 가능하므로 N을 절반으로 나눔
            n /= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
