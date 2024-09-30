import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    
    public static int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품의 종류와 수량을 저장하는 Map 생성
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int validDays = 0; // 조건을 만족하는 날의 개수

        // 슬라이딩 윈도우: discount 배열에서 10일씩 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            // 현재 윈도우에서의 할인 제품들의 개수를 저장할 Map 생성
            Map<String, Integer> discountMap = new HashMap<>();
            
            // 10일 동안의 할인 제품을 체크
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            // 원하는 제품과 수량이 일치하는지 확인
            boolean isValid = true;
            for (String product : wantMap.keySet()) {
                if (discountMap.getOrDefault(product, 0) < wantMap.get(product)) {
                    isValid = false;
                    break;
                }
            }
            
            // 조건을 만족하면 유효한 날로 카운트
            if (isValid) {
                validDays++;
            }
        }

        return validDays;
    }

    public static void main(String[] args) {
        int result = solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    
        System.out.println(result);
    }
}
