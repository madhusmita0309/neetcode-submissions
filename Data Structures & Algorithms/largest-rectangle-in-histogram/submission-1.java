class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> monotonic = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i=0; i<=n; i++){
            while(!monotonic.isEmpty() && (i == n || heights[monotonic.peek()] >= heights[i])){
                int index = monotonic.pop();
                int height = heights[index];
                int width = monotonic.isEmpty() ? i:  i - monotonic.peek()-1;
                maxArea = Math.max(maxArea, height * width);
            }

            monotonic.push(i);
        }

        return maxArea;
    }
}
