package neetcodealgo;

import java.util.Stack;

public class evalRPN {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		int res = evalRPN(tokens);
		System.out.println(res);
	}
	
	 public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = stack.pop();
                System.out.println(a);
                int b = stack.pop();
                System.out.println(b);
                stack.push(a+b);
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }
            else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
