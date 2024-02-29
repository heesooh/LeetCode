// Use DFS to determine whether the course can be finished or not
class Solution {
    // initialize a hash map that will keep track of all of 
    private HashMap<Integer, List<Integer>> courses = new HashMap<>();
    // Create a set that keeps track of all visisted nodes
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // preReq courses; key -> course, value -> preReq
        for (int i=0; i<numCourses; i++) {
            courses.put(i, new ArrayList<>());
        }

        // Update the course -> preReq hash map
        for (int[] preReq: prerequisites) {
            courses.get(preReq[0]).add(preReq[1]);
        }

        // Iterate through each courses
        // There can be unconnected course
        for (int i=0; i<numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int course) {
        // If the course has been visited, then there
        // must be a loop -> return false
        if (visited.contains(course)) {
            return false;
        }
        // If the course does not have any preReq,
        // then return true
        if (courses.get(course).size() == 0) {
            return true;
        }
        // Start dfs 
        // Records current course in visited
        visited.add(course);
        // Iterate through current courses preReqs
        for (int preReq: courses.get(course)) {
            // If any of the preReq cannot be completed
            // return false
            if (!dfs(preReq)) return false;
        }
        // If the course can be completed
        // Remove preReq values from the courses table
        courses.put(course, new ArrayList<>());
        // Remove curr course from the visited set
        visited.remove(course);
        return true;
    }
}