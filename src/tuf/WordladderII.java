package tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordladderII {

	public static void main(String[] args) {
		String beginWord = "der", endWord = "dfs";
		List<String> wordList = new ArrayList<>(Arrays.asList("des", "der", "dfr", "dgt", "dfs"));

		List<List<String>> ans = findSequences(beginWord, endWord, wordList);

		// Output
		System.out.println("The different sequences are:");
		for (List<String> sequence : ans) {
			for (String word : sequence) {
				System.out.print(word + " ");
			}
			System.out.println();
		}

	}

	private static List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
		  // To store the answer
        List<List<String>> ans = new ArrayList<>();
        
        // Queue data structure to store 
        // the sequence of transformations
        Queue<List<String>> q = new LinkedList<>();
        
        // Add all the words to a hashset
        Set<String> st = new HashSet<>(wordList);
        
        // Add the sequence containing starting word to queue
        q.add(new ArrayList<>(Arrays.asList(beginWord)));
        
        // Erase starting word from set if it exists
        st.remove(beginWord);
        
        // Set to store the words that must be deleted 
        // after traversal of a level is complete
        Set<String> toErase = new HashSet<>();
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Size of queue
            int size = q.size();
            
            // Traversing all words in current level
            for (int i = 0; i < size; i++) {
                
                // Sequence 
                List<String> seq = q.poll();
                
                // Last added word in sequence
                String word = seq.get(seq.size() - 1);
                
                // If the last word same as end word
                if (word.equals(endWord)) {
                    // Add the sequence to the answer
                    if (ans.isEmpty()) {
                        ans.add(new ArrayList<>(seq));
                    }
                    else if (ans.get(ans.size() - 1).size() == 
                             seq.size()) {
                        ans.add(new ArrayList<>(seq));
                    }
                }
                
                // Iterate on every character
                for (int pos = 0; pos < word.length(); pos++) {
                    
                    // Original letter
                    char original = word.charAt(pos);
                    
                    // Replacing current character with
                    // letters from 'a' to 'z' to match 
                    // any possible word from set
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[pos] = ch;
                        String newWord = new String(wordArray);
                        
                        // Check if it exists in the set
                        if (st.contains(newWord)) {
                            // Update the sequence
                            seq.add(newWord);
                            
                            // Push in the queue
                            q.add(new ArrayList<>(seq));
                            
                            // Add the word to erase map
                            toErase.add(newWord);
                            
                            // Backtracking step
                            seq.remove(seq.size() - 1);
                        }
                    }
                    
                    // Update the original letter back
                    String beforePos = word.substring(0, pos);
                    String afterPos = word.substring(pos + 1);
                    word = beforePos + original + afterPos;
                }
            }
            
            // Erase all the words in set after
            // traversal of a level is completed
            for (String it : toErase) st.remove(it);
            toErase.clear();
            
            // If answer is found, break
            if (!ans.isEmpty()) break;
        }
        
        // Return the result found
        return ans;
    }

}
