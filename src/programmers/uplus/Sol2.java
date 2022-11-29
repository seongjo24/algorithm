package programmers.uplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sol2 {
    public String solution(String compressed) {
        String answer = "";
        String noRegExp = "^[0-9]+";
        String strRegExp = "^[a-z]+";
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < compressed.length(); i++) {
            char t = compressed.charAt(i);
            String temp = "";
            if (t == ')') {

                while (stack.size() > 0) {

                    if ("(".equals(stack.peek())) {
                        stack.pop();

                        if ("".equals(temp)) {
                            temp = answer.repeat(getNum(noRegExp, stack));
                            temp = getExtrString(stack, temp);
                        } else {
                            temp = temp.repeat(getNum(noRegExp, stack));
                            temp = getExtrString(stack, temp);
                            //System.out.println(temp);
                            temp = answer + temp;
                        }
                        answer = temp;
                        break;
                    } else {
                        temp = stack.pop() + temp;
                    }

                }
            } else {
                stack.push(String.valueOf(t));
            }
            // System.out.println(answer);
            //System.out.println(stack.toString());
        }

        return answer;
    }

    private int getNum(String regExp, Stack<String> stack) {
        String num = "";
        while (stack.size() > 0) {
            if (!stack.peek().matches(regExp)) break;
            else num = stack.pop() + num;
        }
        return Integer.parseInt(num);
    }

    private String getExtrString(Stack<String> stack, String temp) {
        if (stack.size() > 0 && !")".equals(stack.peek()) && !"(".equals(stack.peek())) {
            while (stack.size() > 0) {
                if (")".equals(stack.peek()) || "(".equals(stack.peek()))
                    break;

                temp = stack.pop() + temp;
            }
        }
        return temp;
    }
}
