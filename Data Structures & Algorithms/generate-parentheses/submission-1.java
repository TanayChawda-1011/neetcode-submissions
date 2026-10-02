class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generate(sb, n, n);

        return res;
    }

    public void generate(StringBuilder sb, int open, int close) {
        if(open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }

        if(open > 0) {
            sb.append('(');

            generate(sb, open - 1, close);
            sb.setLength(sb.length() - 1);
        }

        if(close > open) {
            sb.append(')');

            generate(sb, open, close - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
