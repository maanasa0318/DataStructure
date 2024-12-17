package neetcodealgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {


	private int count;
	private Map<Integer, List<int[]>> tweetMap;
	private Map<Integer, Set<Integer>> followmap;

	
	public Twitter(){
		count =0;
		tweetMap = new HashMap<>();
		followmap = new HashMap<>();
	}
	
    public void follow(int followerId, int followeeId) {
    	//followmap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    	if(!followmap.containsKey(followerId)) {
    		HashSet<Integer> set = new HashSet<Integer>();
    		set.add(followeeId);
    		followmap.put(followerId, set);
    	}
    }
    
    public void unfollow(int followerId, int followeeId) {
//    	followmap.computeIfPresent(followerId, (k, v) -> {
//    		v.remove(followerId);
//    		return v;
//    	});
    	if(followmap.containsKey(followerId)) {
    		Set<Integer> set = followmap.get(followerId);
    		if(set.contains(followeeId)) {
    			set.remove(followerId);
    		}
    	}
    }

}
