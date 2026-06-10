class Solution {
    public int findMin(int[] nums) {
        int left = 0; int right = nums.length-1;
        int minNum = nums[left];

        while(left <= right){
            if(nums[left] < nums[right]){
                minNum = Math.min(minNum, nums[left]);
                break;
            }
            int mid = (left + right)/2;
            minNum = Math.min(minNum, nums[mid]);
            if(nums[mid] >= nums[left]){
                left = mid + 1; // search in right portion
                
            }else{
                right = mid - 1; // already in sorted order - search leftwards

            }
        }

        return minNum;
    }
}
