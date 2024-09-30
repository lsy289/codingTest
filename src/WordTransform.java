import java.util.*;

public class WordTransform {

    // 두 단어가 변환 가능한지 체크하는 함수
    public static boolean canTransform(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;  // 두 문자 이상 다르면 변환 불가능
            }
        }
        return diffCount == 1;
    }

    public static int solution(String begin, String target, String[] words) {
        // target이 words에 없는 경우 변환 불가
        List<String> wordList = Arrays.asList(words);
        if (!wordList.contains(target)) {
            return 0;
        }

        // BFS를 위한 큐와 방문 기록용 Set
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(begin);
        visited.add(begin);

        int level = 0;  // BFS 탐색 레벨 (변환 단계)

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            // 현재 레벨에 있는 단어들을 하나씩 꺼내서 변환을 시도
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // words 리스트에서 변환 가능한 단어들을 찾음
                for (String word : words) {
                    if (!visited.contains(word) && canTransform(currentWord, word)) {
                        // target 단어에 도달하면 변환 완료
                        if (word.equals(target)) {
                            return level;
                        }

                        // 변환 가능한 단어를 큐에 추가하고 방문 기록
                        visited.add(word);
                        queue.offer(word);
                    }
                }
            }
        }

        // 변환할 수 없는 경우
        return 0;
    }

    public static void main(String[] args) {
        
        int result = solution("hit", "cog", new String[] {"hot","dot","dog","lot","log","cog"});
        System.out.println(result);
    }    
}