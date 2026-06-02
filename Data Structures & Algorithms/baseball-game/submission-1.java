class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for(String c : operations) {
            if(c.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
                sum += stack.peek();
            } else if(c.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if(c.equals("C")) {
                sum -= stack.pop();
            } else {
                stack.push(Integer.parseInt(c));
                sum += stack.peek();
            }
        }
        return sum;
    }
}