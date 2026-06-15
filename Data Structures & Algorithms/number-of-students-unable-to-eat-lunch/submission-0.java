class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0, zeros = 0;

        for(int i : students)
            if(i == 1)  ones++;
        
        zeros = students.length - ones;

        for(int s : sandwiches) {
            if(s == 0) {
                if(zeros == 0)
                    return ones;
                zeros--;
            }
            else {
                if(ones == 0)
                    return zeros;
                ones--;
            }
        }

        return 0;
    }
}