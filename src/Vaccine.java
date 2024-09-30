import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Vaccine {
    
    public String[] solution(String[] vac, String[] peo) {
        // 백신 재고 및 접종 가능 나이 범위를 저장할 Map
        Map<String, VaccineInfo> vaccineMap = new HashMap<>();
        
        // 백신 정보 처리
        for (String v : vac) {
            String[] parts = v.split(" ");
            String name = parts[0];
            int stock = Integer.parseInt(parts[1]);
            int minAge = Integer.parseInt(parts[2]);
            int maxAge = Integer.parseInt(parts[3]);
            vaccineMap.put(name, new VaccineInfo(stock, minAge, maxAge));
        }
        
        // 접종 희망자 정보 저장
        List<Person> people = new ArrayList<>();
        for (String p : peo) {
            String[] parts = p.split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            List<String> preferences = Arrays.asList(Arrays.copyOfRange(parts, 2, parts.length));
            people.add(new Person(name, age, preferences));
        }
        
        // 나이순으로 정렬, 나이가 같으면 접수 순서 유지
        people.sort((p1, p2) -> Integer.compare(p2.age, p1.age)); // 나이 내림차순 정렬
        
        // 백신 별로 예약자를 저장할 Map
        Map<String, List<String>> reservations = new HashMap<>();
        
        // 접종 희망자 순서대로 백신 배정
        for (Person person : people) {
            for (String preferredVaccine : person.preferences) {
                VaccineInfo vaccine = vaccineMap.get(preferredVaccine);
                
                // 재고가 있고, 나이가 접종 가능 나이 범위에 맞는 경우
                if (vaccine.stock > 0 && person.age >= vaccine.minAge && person.age <= vaccine.maxAge) {
                    // 예약 처리
                    vaccine.stock--;
                    reservations.computeIfAbsent(preferredVaccine, k -> new ArrayList<>()).add(person.name);
                    break; // 첫 번째 가능한 백신을 예약했으므로 다음 사람으로 넘어감
                }
            }
        }
        
        // 결과를 담을 리스트
        List<String> result = new ArrayList<>();
        
        // 백신 이름을 알파벳 순으로 정렬하고, 그에 따른 예약자도 정렬
        for (String vaccineName : new TreeSet<>(reservations.keySet())) {
            List<String> reservedPeople = reservations.get(vaccineName);
            Collections.sort(reservedPeople); // 사람 이름을 알파벳 순으로 정렬
            result.add(vaccineName + " " + String.join(" ", reservedPeople));
        }
        
        // 결과를 배열로 변환하여 반환
        return result.toArray(new String[result.size()]);
    }
    
    // 백신의 재고와 접종 가능 나이 정보를 저장할 클래스
    private static class VaccineInfo {
        int stock;
        int minAge;
        int maxAge;

        VaccineInfo(int stock, int minAge, int maxAge) {
            this.stock = stock;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }
    }
    
    // 접종 희망자의 정보를 저장할 클래스
    private static class Person {
        private String name;
        int age;
        List<String> preferences;

        Person(String name, int age, List<String> preferences) {
            this.name = name;
            this.age = age;
            this.preferences = preferences;
        }
    }
    
    // 테스트 메인 함수
    public static void main(String[] args) {
        Vaccine sol = new Vaccine();
        
        String[] vac = {"PIZER 3 20 99", "ASTRA 1 9 55", "YANSEN 10000 22 49"};
        String[] vac2 = {"Y 1 30 40", "X 9999 1 99", "Z 9 50 65", "T 10000 1 99"};
        String[] peo = {"susan 50 ASTRA YANSEN PIZER", "kevin 55 ASTRA", "luka 60 PIZER ASTRA", "erica 20 YANSEN PIZER ASTRA", "roy 20 PIZER"};
        String[] peo2 = {"aaa 50 Z Y", "bbb 40 Y T X", "cc 30 Y T", "dd 65 Y Z", "gg 1 T"};
        
        String[] result = sol.solution(vac2, peo2);
        System.out.println(Arrays.toString(result)); // ["ASTRA kevin", "PIZER erica luka susan"]
    }
}
