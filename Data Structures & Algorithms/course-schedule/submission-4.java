class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            int crs = prereq[0], pre = prereq[1];
            adjList.get(crs).add(pre);
        }

        for(int c = 0; c < numCourses; c++) {
            if(!dfs(c, adjList, visited))
                return false;
        }

        return true;
    }

    public boolean dfs(int c, Map<Integer, ArrayList<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(c))
            return false;
        if(adjList.get(c).isEmpty())
            return true;

        visited.add(c);

        for(int pre : adjList.get(c)) {
            if(!dfs(pre, adjList, visited))
                return false;
        }

        visited.remove(c);
        adjList.put(c, new ArrayList<>());

        return true;
    }
}
