package programmers.practice;
import java.util.*;
public class CorrectParenthesis {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        answer = (stack.isEmpty()) ? true : false;
        return answer;
    }
}
