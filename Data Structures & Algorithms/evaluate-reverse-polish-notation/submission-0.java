class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;

        for(String s : tokens) {
            char c = s.charAt(0);

            if(s.length() == 1 && (c == '+' || c == '-' || c == '/' || c == '*')) {
                int b = stack[--top];
                int a = stack[--top];

                switch(c) {
                    case '+':
                        stack[top++] = a + b; break;
                    case '-':
                        stack[top++] = a - b; break;
                    case '*':
                        stack[top++] = a * b; break;
                    case '/':
                        stack[top++] = a / b; break;
                }
            } else {
                stack[top++] = Integer.parseInt(s);
            }
        }
        return stack[0];
    }
}
