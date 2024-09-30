public class BlueBerry {
    
    public static boolean solution(int capacity, int[][] routes) {
        // 총 1000개까지의 지점을 추적한다고 가정 (출발지와 도착지가 최대값일 수 있음)
        int[] weightOnPoint = new int[1001];  // 각 지점에서의 누적된 선물의 무게를 저장할 배열

        // 각 배송 정보(무게, 출발지, 도착지)에 대해 처리
        for (int[] delivery : routes) {
            int weight = delivery[0];  // 선물의 무게
            int from = delivery[1];    // 출발지
            int to = delivery[2];      // 도착지

            // 출발지와 도착지 사이의 구간에 무게를 추가
            for (int i = from; i < to; i++) {
                weightOnPoint[i] += weight;

                // 만약 어느 구간에서든 누적 무게가 최대 무게를 초과하면 false를 반환
                if (weightOnPoint[i] > capacity) {
                    return false;
                }
            }
        }

        // 무게가 모두 안전하다면 true를 반환
        return true;
    }


    public static void main(String[] args) {

        boolean result = BlueBerry.solution(9, new int[][] {{3,12,16},{8,2,12},{1,14,15}});
        System.out.println(result);
    }
}
