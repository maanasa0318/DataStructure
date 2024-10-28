package string;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
 
		String s = "egg";
		String t = "add";
		System.out.println(isIsoMorphic(s,t));
		
	}

	private static boolean isIsoMorphic(String s, String t) {
	    HashMap<Character,Character> map = new HashMap<>();
	    if(s.length() != t.length()){
	    	return false;
	    }
	    else {
	    	char[] ch = t.toCharArray();
	    	for(int i=0; i<s.length(); i++) {
	    		char c = ch[i];
	    		boolean keyPresnt = map.containsKey(s.charAt(i));
	    
	    		if(keyPresnt && !map.get(s.charAt(i)).equals(c)) {
	    			return false;
	    		}
	    		
	    		else if(!keyPresnt && map.containsValue(c)) {
	    			return false;
	    		}
	    		else {
	    			map.put(s.charAt(i), c);
	    		}
	    	}
	    }
	    
		return true;
	}

}
