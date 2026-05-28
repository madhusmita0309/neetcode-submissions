class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        Deque<Integer> monoDecStack = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){
            while(!monoDecStack.isEmpty() && temperatures[i] > temperatures[monoDecStack.peek()]){
                int index = monoDecStack.pop();
                result[index] = i - index;
            }

           
            monoDecStack.push(i); 
        }

        return result;

    }
}
