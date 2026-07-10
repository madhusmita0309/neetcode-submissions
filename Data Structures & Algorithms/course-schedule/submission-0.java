class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prereqMap = new HashMap();
        for(int i=0; i<numCourses; i++){
            prereqMap.put(i, new ArrayList());
        }

        for(int[] p: prerequisites){
            int pre = p[0]; int node = p[1];
            prereqMap.get(node).add(pre); // adjacency list
        }

        Set<Integer> visitingSet = new HashSet();
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, visitingSet, prereqMap)) // dfs on each course 
                return false;
        }

        return true;
    }

    public boolean dfs(int c, Set<Integer> visitingSet, HashMap<Integer, List<Integer>> prereqMap){
        
        if(visitingSet.contains(c))
            return false;  // course c is indirectly needed for course c => cycle detected

        List<Integer> preReq = prereqMap.get(c);
        if(prereqMap.get(c).size() == 0)
            return true; // no pre req

        visitingSet.add(c); // req list populated along the path
        for(int pre : prereqMap.get(c)){
            if(!dfs(pre, visitingSet, prereqMap))
                return false;
        }

        visitingSet.remove(c); // course criteria fulfilled so remove from set of needed prereq list path
        // make the prereq map empty as all prereq can be fulfilled
        prereqMap.put(c, new ArrayList());
        return true;
    }
}
