package programmers.MonthlyCodeChallenge;
import java.util.*;
public class RotateParentheses {

    public int solution(String s) {
        int answer = 0;
        String new_s = s;
        for(int i = 0; i < s.length(); i++){
            if(checkString(new_s)) answer++;
            new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
        }

        return answer;
    }

    boolean checkString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            try{
                switch(s.charAt(i)){
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if(stack.peek() != '[') return false;
                        stack.pop();
                        break;
                    case '{':
                        stack.add('{');
                        break;
                    case '}':
                        if(stack.peek() != '{') return false;
                        stack.pop();
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(stack.peek() != '(') return false;
                        stack.pop();
                        break;
                }
            } catch(Exception e){
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
