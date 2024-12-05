package neetcodealgo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		
		List<String> res = generateParenthesis(3);
		System.out.println(res);
		
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		backtrack(0,0,n,res, sb);
		return res;
        
    }

	// only add openPraent if open < n
	// only add close praenthesis if closed < open
	// valid of open == closed == n
	private static void backtrack(int open, int closed, int n, List<String> res, StringBuilder sb) {
		if(open == closed && open == n) {
			res.add(sb.toString());
			return;
		}
		if(open < n) {
			sb.append("(");
			backtrack(open +1, closed, n, res, sb);
			sb.deleteCharAt(sb.length() -1);
		}
		if(closed < open) {
			sb.append(")");
			backtrack(open, closed +1, n, res, sb);
			sb.deleteCharAt(sb.length() -1);
		}
		
	}

}
