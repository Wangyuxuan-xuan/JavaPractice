package Leetcode;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();

        System.out.println(Arrays.toString(courseScheduleII.findOrder(5, new int[][]{{1, 2},{2,3},{4,0}})));

    }

    HashMap<Integer , List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> cycle = new HashSet<>();

    HashSet<Integer> visited = new HashSet<>();
    List<Integer> output = new ArrayList<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {

            preMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {

            if (!dfs(i))
                return new int[]{};
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int current){

        if (cycle.contains(current))
            return false;

        if (visited.contains(current))
            return true;

        cycle.add(current);

        for(Integer pre : preMap.get(current)){

            if (!dfs(pre))
                return false;
        }

        cycle.remove(current);
        visited.add(current);
        output.add(current);

        return true;
    }

}
