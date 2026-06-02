class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for(String c : ops) {
            if(c.equals("C"))
                sum -= stack.pop();
            else if(c.equals("D")) {
                int val = stack.peek() * 2;
                stack.push(val);
                sum += val;
            }
            else if(c.equals("+")) {
                int prevTop = stack.pop();
                int newTop = stack.peek() + prevTop;
                stack.push(prevTop);
                stack.push(newTop);
                sum += newTop;
            } else {
                int val = Integer.parseInt(c);
                stack.push(val);
                sum += val;
            }
        }

        return sum;
    }
}