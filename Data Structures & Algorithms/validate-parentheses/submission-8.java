class Solution {
    private static final Map<Character, Character> bracs = Map.of(
        '}', '{', 
        ']', '[',
        ')', '('
    );

    public boolean isOpen(char c) {
        return c == '[' || c == '(' || c == '{';
    }
    
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(isOpen(c))
                stack.push(c);
            else if(!stack.isEmpty() && stack.peek() == bracs.get(c))
                stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }
}
