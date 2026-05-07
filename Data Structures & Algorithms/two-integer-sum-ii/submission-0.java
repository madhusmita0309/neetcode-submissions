class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<numbers.length; i++){
            if(numMap.containsKey(numbers[i])){
                result[0] = numMap.get(numbers[i]);
                result[1] = i+1;
                return result;
            }
            numMap.put(target - numbers[i], i+1);

        }
        return result;
    }
}
