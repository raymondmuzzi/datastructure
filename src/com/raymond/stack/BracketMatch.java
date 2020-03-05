package com.raymond.stack;

import java.util.Stack;

/**
 * @author raymondmuzzi
 * @date 2020-02-25 16:38:15
 */
public class BracketMatch {

    public static void main(String[] args) {
        BracketMatch bracketMatch = new BracketMatch();
        boolean value = bracketMatch.isValue("{ss[dd]()(})");
        System.out.println(value);

    }

    public boolean isValue(String s) {
        Stack<Character> leftStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                leftStack.push(c);
            else {
                if (leftStack.isEmpty())
                    return false;
                char topChar = leftStack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return leftStack.isEmpty();
    }
}