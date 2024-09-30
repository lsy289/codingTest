import java.util.*;

public class Siso {

    public long solution(int[] weights) {
        // 무게별로 사람의 수를 저장할 Map
        Map<Integer, Long> weightCount = new HashMap<>();
        long result = 0;
        
        // 무게별 사람 수 카운팅
        for (int weight : weights) {
            weightCount.put(weight, weightCount.getOrDefault(weight, 0L) + 1);
        }
        
        // 각 무게에 대해 시소 짝꿍이 될 수 있는 경우를 찾음
        for (Map.Entry<Integer, Long> entry : weightCount.entrySet()) {
            int weight = entry.getKey();
            long count = entry.getValue();
            
            // 같은 무게끼리 짝꿍이 되는 경우 (같은 좌석에 앉는 경우)
            if (count > 1) {
                result += (count * (count - 1)) / 2;  // 같은 무게 사람들끼리의 쌍을 찾는 경우
            }
            
            // 거리 비율이 2:3, 2:4, 3:4인 경우를 각각 비교하여 짝꿍 찾기
            result += checkPair(weightCount, weight, 2, 3);
            result += checkPair(weightCount, weight, 2, 4);
            result += checkPair(weightCount, weight, 3, 4);
        }
        
        return result;
    }
    
    // 비율을 이용한 짝꿍 계산 함수
    private long checkPair(Map<Integer, Long> weightCount, int weight, int distA, int distB) {
        int otherWeight = weight * distB / distA;
        if (weight * distB % distA == 0 && weightCount.containsKey(otherWeight)) {
            return weightCount.get(weight) * weightCount.get(otherWeight);
        }
        return 0;
    }


    public static void main(String[] args) {
        
        Siso siso = new Siso();

        long result = siso.solution(new int[] {100,180,360,100,270});
        System.out.println(result);
    }

}