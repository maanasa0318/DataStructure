package neetcodealgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
	
	private static Map<Integer, List<Integer>> preMap = new HashMap<>();
	private static Set<Integer> visiting = new HashSet<>();

	public static void main(String[] args) {

		int[][] prerequisites = { { 0, 1 } };
		int numCourses = 2;
		boolean res = canFinish(numCourses, prerequisites);
		System.out.println(res);

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		
		for(int i=0; i<numCourses; i++) {
			preMap.put(i, new ArrayList<>());
		}
		
		for(int[] pre : prerequisites) {
			
			int course = pre[0];
			int reqCourse = pre[1];
			System.out.println(course+":"+reqCourse);
			preMap.get(course).add(reqCourse);
		}
		
		for(int i=0; i<numCourses; i++) {
			if(!dfs(i)) {
				return false;
			}
		}
		
		return true;

	}

	private static boolean dfs(int course) {
		if(visiting.contains(course)) {
			//cycle detected
			return false;
		}
		
		if(preMap.get(course).isEmpty()){
			return true;
		}
		
		visiting.add(course);
		for(int c : preMap.get(course)) {
			if(dfs(c)) {
				return false;
			}
		}
		
		visiting.remove(course); // no longer visiting this
		preMap.put(course, new ArrayList<>()); // add course with empty list so return true;
		return true;
	}
}
