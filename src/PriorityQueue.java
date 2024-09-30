import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueue {

    public static int solution(int[] priorities, int location) {
        // 큐를 생성하고 프로세스의 우선순위와 인덱스를 저장
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]}); // {인덱스, 우선순위}
        }
        
        int order = 0; // 실행된 순서를 기록
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 프로세스 꺼냄
            boolean hasHigherPriority = false;
            
            // 큐에 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 확인
            for (int[] process : queue) {
                if (process[1] > current[1]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            // 더 높은 우선순위가 있으면 다시 큐에 넣음
            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                // 실행할 수 있는 프로세스
                order++; // 실행된 순서 증가
                
                // 실행한 프로세스가 우리가 찾던 프로세스인 경우 순서 반환
                if (current[0] == location) {
                    return order;
                }
            }
        }
        
        return -1; // 오류 방지용
    }
    

    public static void main(String[] args) {
        
        int reulst = solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
    
        System.out.println(reulst);
    }
}
