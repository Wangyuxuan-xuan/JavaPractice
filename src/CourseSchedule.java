import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {

    HashMap<Integer , List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i , new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            List<Integer> current = preMap.get(pre[0]);
            current.add(pre[1]);
            preMap.put(pre[0] , current);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        }

        return true;
    }

    public boolean dfs(int current){

        if (visited.contains(current))
            return false;

        if (preMap.get(current).isEmpty()){
            return true;
        }

        visited.add(current);
        for(int element : preMap.get(current)){
            if (!dfs(element))
                return false;

            visited.remove(current);
            preMap.put(element, new ArrayList<>());

        }

        return true;
    }

}
