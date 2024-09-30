import java.util.*;

public class Diamond {
    
    public static int[] solution(String[] gems) {
        // 보석 종류의 개수를 파악 (중복 제거된 보석의 수)
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalGemTypes = gemTypes.size(); // 보석 종류의 총 개수
        
        // 보석의 종류와 그 개수를 저장할 Map
        Map<String, Integer> gemCountMap = new HashMap<>();
        
        int start = 0, end = 0;  // 투 포인터
        int minStart = 0, minEnd = gems.length; // 최소 구간을 저장할 변수
        
        while (end < gems.length) {
            // 1. 현재 구간에 보석 추가
            gemCountMap.put(gems[end], gemCountMap.getOrDefault(gems[end], 0) + 1);
            end++;
            
            // 2. 모든 보석 종류가 포함되었을 때
            while (gemCountMap.size() == totalGemTypes) {
                // 3. 최소 구간을 갱신
                if (end - start < minEnd - minStart) {
                    minStart = start;
                    minEnd = end;
                }
                
                // 4. 구간의 시작 보석 제거
                gemCountMap.put(gems[start], gemCountMap.get(gems[start]) - 1);
                if (gemCountMap.get(gems[start]) == 0) {
                    gemCountMap.remove(gems[start]);
                }
                start++;
            }
        }
        
        // 구간은 1-based index로 반환
        return new int[]{minStart + 1, minEnd};
    }

    public static void main(String[] args) {
        
        int[] result = solution(new String[] {"AA", "AB", "AC", "AA", "AC"});
        System.out.println(Arrays.toString(result));
    }
}
