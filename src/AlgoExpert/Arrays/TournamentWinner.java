package AlgoExpert.Arrays;

import java.util.*;

public class TournamentWinner {

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();

        competitions.add(new ArrayList<>(Arrays.asList("HTML", "C#")));
        competitions.add(new ArrayList<>(Arrays.asList("C#", "Python")));
        competitions.add(new ArrayList<>(Arrays.asList("Python", "HTML")));

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions,results));
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            int result = results.get(i);
            //学一学呀
             hashMap.merge(result == 1 ? competition.get(0) : competition.get(1),3,Integer::sum);
        }

        ArrayList<Integer> points = new ArrayList<>(hashMap.values());
        points.sort(Comparator.reverseOrder());
        String winner = "";
        for(Map.Entry<String ,Integer> entry : hashMap.entrySet()){
            //Null-safe equals
            if (Objects.equals(entry.getValue(), points.get(0))){
                winner = entry.getKey();
            }
        }
        return winner;
    }

}
