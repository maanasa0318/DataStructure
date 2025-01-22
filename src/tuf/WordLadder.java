package tuf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	static class Pair{
		String word;
		int step;
		
		public Pair(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}

	public static void main(String[] args) {

		String startWord = "der", targetWord = "dfs";
        List<String> wordList = 
        Arrays.asList("des", "der", "dfr", "dgt", "dfs");

  
        int ans = 
        wordLadderLength(startWord, targetWord, wordList);

        // Output
        System.out.println("Word ladder length is: " + ans);
	}

	private static int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startWord, 1));
		Set<String> st = new HashSet<>(wordList);
		st.remove(startWord);
		while(!q.isEmpty()) {
			String word = q.peek().word;
			System.out.println("Word="+word);
			int step = q.peek().step;
			q.poll();
			
			if(word.equals(targetWord)) {
				return step;
			}
			
			for(int i=0; i<word.length(); i++) {
				char originalWord = word.charAt(i);
				System.out.println("originalWord=" + originalWord);
				
				for(char ch ='a'; ch <= 'z'; ch++) {
					char[] wordArray = word.toCharArray();
					wordArray[i] = ch;
					String newWord = new String(wordArray);
					System.out.println("Neword=" + newWord);
					
					if(st.contains(newWord)) {
						st.remove(newWord);
						q.add(new Pair(newWord, step +1));
					}
				}
				
				word = word.substring(0, i) + originalWord + word.substring(i +1);

				
			}
			
		}
		
		
		
		return 0;
		
	}

}
