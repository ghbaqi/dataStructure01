package com.gh.ds._02.stack;

import java.util.Stack;

// 对后续数据的计算 , 需要前面步骤的数据或者计算结果 ,  就可以考虑使用 栈

public class Solution1047 {


    public String removeDuplicates(String S) {

        if (S == null || S.trim().equals(""))
            return S;

        Stack<Character> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));

            } else {
                char peek = stack.peek();
                if (S.charAt(i) == peek) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }


    public String removeDuplicates22(String S) {

        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();

        System.out.println(solution1047.removeDuplicates("aba"));
        System.out.println(solution1047.removeDuplicates("abbaca"));
    }


}
