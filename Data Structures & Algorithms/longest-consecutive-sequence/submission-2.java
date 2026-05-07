class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet();
        if(nums.length == 0)
            return 0;

        for(int num: nums){
            numSet.add(num);
        }
        int longest = 1;
        for(int i=0; i<nums.length; i++){
            if(numSet.contains(nums[i]-1)){
                int length = 1;
                while(numSet.contains(nums[i]-length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
