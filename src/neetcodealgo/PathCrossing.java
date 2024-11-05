package neetcodealgo;

import java.util.HashSet;

public class PathCrossing {

	public static void main(String[] args) {

		String path = "NESWW";
		boolean res = isPathCrossing(path);
		System.out.println(res);
	}
     //     x,y   
	// N - (0, 1)
	// S - (0, -1)
	// W - (-1, 0)
	// E - (1, 0)
	private static boolean isPathCrossing(String path) {
		int x=0;
		int y =0;
		HashSet<String> visted = new HashSet<>();
		visted.add("0,0");
		
		for(Character direction : path.toCharArray()) {
			if(direction == 'N') {
				x++;
			}
			if(direction == 'S') {
				x--;
			}
			if(direction == 'E') {
				y++;
			}
			if(direction == 'W') {
				y--;
			}
			
			String currentPos = x + "," + y;
			if(visted.contains(currentPos)) {
				return true;
			}
			visted.add(currentPos);
		}
		return false;
	}

}
