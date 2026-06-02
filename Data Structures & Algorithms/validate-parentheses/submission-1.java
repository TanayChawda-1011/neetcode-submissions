class Solution {
    public boolean isOpen(char c) {
        if(c == '(' || c == '[' || c == '{')
            return true;
        else
            return false;
    }

    public boolean isValid(String s) {
        char c = ' ';
        Stack<Character> brack = new Stack<Character>();
        Map<Character, Character> brackLookup = new HashMap<Character, Character>();

        brackLookup.put('{', '}');
        brackLookup.put('[', ']');
        brackLookup.put('(', ')');

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(isOpen(c)) {
                brack.push(c);
            } else if(!isOpen(c) && !brack.empty() && c == brackLookup.get(brack.peek())) {
                brack.pop();
            } else {
                return false;
            }
        }

        return brack.isEmpty();
    }
}
