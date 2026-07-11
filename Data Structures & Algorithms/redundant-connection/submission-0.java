class Solution {
    public int parent[];
    public int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        Arrays.fill(rank, 1);
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            boolean cycleOrNot = union(edge[0], edge[1]);
            if(cycleOrNot){
                return edge;
            }
                
        }
        return new int[]{};
    }

    public int find(int n1){
        if(n1 == parent[n1])
            return n1;

        return find(parent[n1]);
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1); int p2 = find(n2);

        if(p1 == p2)
            return true;
        
        if(rank[p1] > rank[p2]){
            rank[p1] += rank[p2];
            parent[p2] = p1;
        }else{
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }

        return false;
    }
}
