class Solution {
    public int search(int[] nums, int target) {
        int left = 0; int right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target == nums[mid])
                return mid;

            if(nums[left] <= nums[mid]){
                // left sorted portion
                if(nums[left] <= target && target < nums[mid]){
                    // search this left portion
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // right sorted portion
                if(target > nums[mid] && target <= nums[right]){
                    // search this portion
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }

            } 
        }
        return -1;
    }
}
