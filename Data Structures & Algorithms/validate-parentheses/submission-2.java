class Solution {
    public boolean isOpenBracket(Character c) {
        return c == '{' || c == '[' || c == '(';
    }
    
    public boolean isValid(String s) {
        Character c = ' ';
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> bracs = new HashMap<Character, Character>();
        
        bracs.put('}', '{');
        bracs.put(')', '(');
        bracs.put(']', '[');

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(isOpenBracket(c))
                stack.push(c);
            else if(!stack.empty() && bracs.get(c).equals(stack.peek())) {
                    stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
