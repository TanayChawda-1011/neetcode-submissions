class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for(String c : operations) {
            if(c.equals("+")) {
                int prevTop = stack.pop();
                int newTop = prevTop + stack.peek();
                stack.push(prevTop);
                stack.push(newTop);
                sum += newTop;
            } else if(c.equals("D")) {
                int val = stack.peek() * 2;
                stack.push(val);
                sum += val;
            } else if(c.equals("C")) {
                sum -= stack.pop();
            } else {
                int val = Integer.parseInt(c);
                stack.push(val);
                sum += val;
            }
        }
        return sum;
    }
}