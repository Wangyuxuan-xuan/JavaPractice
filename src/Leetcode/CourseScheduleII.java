package Leetcode;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(5, new int[][]{{1, 2},{2,3},{4,0}})));
    }

    HashMap<Integer , List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> cycle = new HashSet<>();
    Set<Integer> orderVisited = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i , new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> current = preMap.get(prerequisite[0]);
            current.add(prerequisite[1]);
            preMap.put(prerequisite[0], current);
        }

        for (int i = 0; i < numCourses; i++) {
            if (orderVisited.contains(i))
                continue;
            boolean result = dfs(i);
            if (!result)
                return new int[]{};
        }

        return result
                .stream().mapToInt(Integer::intValue)
                .toArray();
    }

    public boolean dfs(int current){
        if (cycle.contains(current)){
            result = new ArrayList<>();
            return false;
        }


        if (preMap.get(current).isEmpty()){
            result.add(current);
            orderVisited.add(current);
            return true;
        }

        cycle.add(current);
        for (int element: preMap.get(current)) {

            if (orderVisited.contains(element))
                continue;


            if (!dfs(element)){
                result = new ArrayList<>();
                return false;
            }

        }
        cycle.remove(current);
        result.add(current);
        orderVisited.add(current);
        System.out.println(orderVisited);
        preMap.put(current , new ArrayList<>());
        return true;
    }
}
