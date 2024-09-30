import java.util.*;

public class Players {

    public String[] codingLogic(String[] players, String[] callings) throws Exception {

        Map<String, Integer> positionMap = new HashMap<>();
        
        for (int idx = 0; idx < players.length; idx++) {
            positionMap.put(players[idx], idx);
        }
   

        for (String calling : callings) {
            
            int targetIndex = positionMap.get(calling);

            if (targetIndex > 0) {

                String selectedPlayer = players[targetIndex - 1];
                
                positionMap.put(selectedPlayer, targetIndex);
                positionMap.put(calling, targetIndex - 1);

                players[targetIndex] = selectedPlayer;
                players[targetIndex - 1] = calling;
            }
        }

        return players;
    }


    public static void main(String[] args) throws Exception {
        
        Players solution = new Players();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution.codingLogic(players, callings);
        System.out.println(Arrays.toString(result));
    }
}
