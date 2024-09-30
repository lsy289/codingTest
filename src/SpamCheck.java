import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpamCheck {
    
    // 연락처 목록과 스팸 번호 목록을 HashSet으로 관리
    public int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        // 연락처 목록과 스팸 번호 목록을 Set으로 관리
        Set<String> contactSet = new HashSet<>(Arrays.asList(approved));
        Set<String> spamSet = new HashSet<>(Arrays.asList(spams));
        
        // 전화번호별로 걸려온 횟수를 기록할 Map
        Map<String, Integer> callCount = new HashMap<>();
        
        // 결과를 담을 배열
        int[] result = new int[calls.length];

        // 각 전화번호가 걸려올 때마다 처리
        for (int i = 0; i < calls.length; i++) {
            String phoneNumber = calls[i];

            // 1. 스팸 번호는 무조건 경고 표시
            if (spamSet.contains(phoneNumber)) {
                result[i] = 1;
                continue;
            }

            // 2. 연락처에 있는 번호는 경고 표시하지 않음
            if (contactSet.contains(phoneNumber)) {
                result[i] = 0;
                continue;
            }

            // 3. 연락처에도 없고 스팸도 아니면 횟수를 체크
            callCount.put(phoneNumber, callCount.getOrDefault(phoneNumber, 0) + 1);
            
            // 4. k번 이하로 걸려온 경우 경고 표시
            if (callCount.get(phoneNumber) <= k) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    // 테스트 메인 메서드
    public static void main(String[] args) {
        SpamCheck sol = new SpamCheck();
        
        String[] approved = {"123-4567", "451-2314", "015-1643"};
        String[] approved2 = {"123-1000"};
        String[] spams = {"111-1111"};
        String[] spams2 = {"456-2000"};
        String[] calls = {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111"};
        String[] calls2 = {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "789-3000", "789-3000", "789-3000", "789-3000"};
        int k = 2;
        int k2 = 3;
        
        int[] result = sol.solution(approved2, spams2, calls2, k2);
        System.out.println(Arrays.toString(result));
    }
}
