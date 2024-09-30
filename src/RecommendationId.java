import java.util.*;

public class RecommendationId {
    
    private String solution(String new_id) {
        return new KakaoNewId(new_id)
            .replaceToLowerCase()
            .filterCharactersByRule()
            .reaplceSingleDotIfOverThanTwo()
            .removeDotFirstAndLastPosition()
            .addSampleIfEmpty()
            .removeLengthIfGreaterThan16()
            .fillLastValueIfLessThan2()
            .getResult();
    }

    private static class KakaoNewId {
        private String id;

        KakaoNewId(String id) {
            this.id = id;
        }

        private KakaoNewId replaceToLowerCase() {
            id = id.toLowerCase();
            return this;
            
        }
        
        private KakaoNewId filterCharactersByRule() {
            id = id.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KakaoNewId reaplceSingleDotIfOverThanTwo() {
            id = id.replaceAll("(\\.)\\1+", "$1");
            return this;
        }

        private KakaoNewId removeDotFirstAndLastPosition() {
            id = id.replaceAll("^[.]|[.]$", "");
            return this;
        }
        
        private KakaoNewId addSampleIfEmpty() {
            if (id.length() == 0 || "".equals(id) || id == null) {
                id = "a";
            }
            return this;
        }

        private KakaoNewId removeLengthIfGreaterThan16() {
            if (id.length() >= 16) {
                id = id.substring(0, 15);
                id = id.replaceAll("[.]$", "");
            }
            return this;
        }

        private KakaoNewId fillLastValueIfLessThan2() {
            String lastText = id.substring(id.length() - 1, id.length());
            if (id.length() < 3) {
                for (int idx = 0; idx < 3; idx++) {
                    if (id.length() == 3) {
                        break;
                    }
                    id += lastText;
                }
            }
            return this;
        }

        private String getResult() {
            return id;
        }
    }

    public static void main(String[] args) {
        RecommendationId recommendationId = new RecommendationId();

        String new_id = "=.=";
        String result = recommendationId.solution(new_id);
        System.out.println(result);
    }
}