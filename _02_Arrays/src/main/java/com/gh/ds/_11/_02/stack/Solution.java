package com.gh.ds._11._02.stack;

import java.util.Stack;

public class Solution {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if (s == null || s.equals(""))
            return true;

        Stack<Character> stack = new Stack<>();
        String cs;

        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            cs = new String(new char[]{s.charAt(i)});

            // 左括号 入栈
            if ("{".equals(cs) || "[".equals(cs) || "(".equals(cs)) {
                stack.push(s.charAt(i));

                // 右括号  弹出栈顶元素进行比较
            } else {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char pop = stack.pop();

                if (pop == '{') {
                    if (s.charAt(i) != '}') {
                        valid = false;
                        break;
                    }
                } else if (pop == '(') {
                    if (s.charAt(i) != ')') {
                        valid = false;
                        break;
                    }
                } else if (pop == '[') {
                    if (s.charAt(i) != ']') {
                        valid = false;
                        break;
                    }
                } else {
                    throw new RuntimeException("非法的输入");
                }


            }
        }

        if (!stack.isEmpty())
            valid = false;


        return valid;

    }

    public static void main(String[] args) {

//        System.out.println("[".equals("[".charAt(0)));

        Solution solution = new Solution();
        boolean valid = solution.isValid("{[]}");
        System.out.println(valid);


    }
}
