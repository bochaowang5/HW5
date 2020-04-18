import java.util.*;

public class hw5 {

    public static void main(String args[]){
        String str1 = "(){}";
        String str2 = "({})";
        String str3 = "({{})";
        System.out.println(isValidBrackets(str1));
        System.out.println(isValidBrackets(str2));
        System.out.println(isValidBrackets(str3));
        int[] dolls1 = {1, 2, 3, 4, 3, 2, 4, 5};
        System.out.println(minDolls(dolls1));
    }

    public static boolean isValidBrackets(String brackets) {
        if(brackets == null || brackets.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = brackets.toCharArray();
        for(char c: chars){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else if(c==')'){
                char curr = stack.peek();
                if(curr == '(')
                    stack.pop();
                else
                    return false;
            }
            else if(c==']'){
                char curr = stack.peek();
                if(curr == '[')
                    stack.pop();
                else
                    return false;
            }
            else if(c=='}'){
                char curr = stack.peek();
                if(curr == '{')
                    stack.pop();
                else
                    return false;
            }
            else
                return false;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static int minDolls(int[] dolls)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int d : dolls){
            if(map.containsKey(d))
                map.put(d, map.get(Integer.valueOf(d)) + 1);
            else
                map.put(d, Integer.valueOf(1));
        }
        Integer max = Integer.MIN_VALUE;
        for(Integer v : map.values()){
            if(v > max)
                max = v;
        }
        return (int)max;
    }

}
