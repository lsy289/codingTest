import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Jellry2 {
    
    public static int solution(String[] pouches) {
        int pocketCount = 0;

        for (String str : pouches) {
            // 알파벳의 빈도를 저장할 맵
            Map<Character, Integer> frequencyMap = new HashMap<>();

            // 각 문자열에서 알파벳의 빈도를 계산
            for (char ch : str.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }

            // 가장 많이 등장한 알파벳의 빈도를 찾음
            int maxFrequency = 0;
            for (int freq : frequencyMap.values()) {
                maxFrequency = Math.max(maxFrequency, freq);
            }

            // 다른 알파벳이 있는지 확인 (maxFrequency보다 작은 값이 있으면 다른 알파벳이 있는 것)
            boolean hasOtherChars = false;
            for (int freq : frequencyMap.values()) {
                if (freq != maxFrequency) {
                    hasOtherChars = true;
                    break;
                }
            }

            // 주머니 계산 로직
            if (maxFrequency > 1 || hasOtherChars) {
                pocketCount++; // 주머니가 필요
            }

            // 문자열이 길이 1인 경우는 제외
            if (str.length() > 1 && hasOtherChars) {
                pocketCount++; // 다른 문자가 있는 경우 주머니 추가
            }
        }

        return pocketCount;
    }

    public static void main(String[] args) {
        String[] input1 = {"cab", "adaaa", "e"}; // 예상 결과: 3
        String[] input2 = {"aabb", "baba"}; // 예상 결과: 0
        String[] input3 = {"d", "a", "e", "d", "abdcc"}; // 예상 결과: 3
        String[] input4 = {"a"}; // 예상 결과: 1
        
        System.out.println(solution(input1)); // 출력: 3
        System.out.println(solution(input2)); // 출력: 0
        System.out.println(solution(input3)); // 출력: 3
        System.out.println(solution(input4)); // 출력: 1
    }
}
