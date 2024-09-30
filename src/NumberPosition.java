public class NumberPosition {
    
    public int solution(int n) {
        int digit = 1;          // 현재 자리수
        long count = 9;         // 해당 자리수의 숫자 개수
        long totalDigits = 0;   // 누적 자릿수 합계

        // 1. n이 속하는 자리수를 찾음
        while (n > totalDigits + digit * count) {
            totalDigits += digit * count; // 누적 자릿수 갱신
            digit++;                      // 자리수 증가
            count *= 10;                  // 숫자 개수 갱신
        }

        // 2. n이 속하는 숫자를 계산
        n -= totalDigits; // n을 현재 자리수 범위 내로 조정
        long num = (long)Math.pow(10, digit - 1) + (n - 1) / digit;

        // 3. 해당 숫자에서 원하는 자릿수를 추출
        int indexInNumber = (int)((n - 1) % digit);

        // 4. 문자열 변환 없이 자릿수 추출
        // 최대 자리수가 9이므로 반복문 사용
        for (int i = 0; i < digit - indexInNumber - 1; i++) {
            num /= 10;
        }
        int result = (int)(num % 10);
        return result;
    }

    // 테스트 메인 함수
    public static void main(String[] args) {
        NumberPosition sol = new NumberPosition();

        // 테스트 케이스
        System.out.println(sol.solution(5));        // 출력: 5
        System.out.println(sol.solution(15));       // 출력: 2
        System.out.println(sol.solution(1000000000)); // 큰 n 값에 대한 테스트
    }
}
