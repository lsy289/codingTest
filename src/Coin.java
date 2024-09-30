public class Coin {
    
    public static int solution(int n, int[] money) {
        // DP 배열 초기화 (n원을 만들 수 있는 방법의 수를 저장)
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 0원을 만드는 방법은 1가지 (아무 동전도 사용하지 않는 경우)

        // 각 동전 단위에 대해 DP 배열을 업데이트
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1_000_000_007;
            }
        }

        // n원을 만드는 방법의 수를 반환
        return dp[n];
    }

    public static void main(String[] args) {
        int reulst = solution(5, new int[] {1,2,5});
        System.out.println(reulst);
    }   
}
