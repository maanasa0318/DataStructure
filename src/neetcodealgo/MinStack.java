package neetcodealgo;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() ||  val <= minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        if(top == minstack.peek()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
