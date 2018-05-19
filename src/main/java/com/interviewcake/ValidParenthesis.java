package com.interviewcake;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class ValidParenthesis {

	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		//System.out.println(isValid("()"));
		//System.out.println(isValid("((((((((("));
        
		PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2) -> p2 - p1);
		pq.add(10);
		pq.add(30);
		pq.add(-3);
		
		Integer value = pq.poll();
		System.out.println("value"+value);
		value = pq.poll();
		System.out.println("value"+value);
		value = pq.poll();
		System.out.println("value"+value);

		
		
		
	}

}
