import java.util.Arrays;

public class battery {
    
    public int solution(int n, int[][] battery) {
        // 구매할 수 있는 최대 배터리 수를 설정
        int maxBatteries = n + 10; // 여유롭게 두 배로 잡아봄 (필요한 수량 이상을 구매할 수 있게)
        
        // dp 배열 초기화, 무한대 비용으로 초기 설정
        int[] dp = new int[maxBatteries + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 배터리 0개를 구매하는 데 필요한 비용은 0
        
        // 동적 계획법을 이용하여 최소 비용 계산
        for (int[] option : battery) {
            int unit = option[0]; // 판매 단위
            int price = option[1]; // 단위 가격

            for (int i = unit; i <= maxBatteries; i++) {
                if (dp[i - unit] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - unit] + price);
                }
            }
        }

        // 최소 비용 찾기: n개 이상의 배터리 중 가장 작은 비용을 찾음
        int minCost = Integer.MAX_VALUE;
        for (int i = n; i <= maxBatteries; i++) {
            minCost = Math.min(minCost, dp[i]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        battery sol = new battery();
        
        // 테스트 예시 1
        int n1 = 50;
        int[][] battery1 = {{10, 100000}, {4, 35000}, {1, 15000}};
        System.out.println(sol.solution(n1, battery1)); // 출력: 450000
        
        // 테스트 예시 2
        int n2 = 20;
        int[][] battery2 = {{6, 30000}, {3, 18000}, {4, 28000}, {1, 9500}};
        System.out.println(sol.solution(n2, battery2)); // 출력: 108000
    }
}
