class Solution {
    static int findMax(int[] piles){
        int maxNum = 0;
        for(int i=0; i<piles.length; i++){
            maxNum = Math.max(maxNum, piles[i]);
        }

        return maxNum;
    }

    static int findHours(int k, int[] piles){
        int result = 0;
        for(int i=0; i<piles.length; i++){
            result = result + (int)Math.ceil((double)piles[i]/k);
        }

        return result;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);

        int minBananas = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int hours = findHours( mid, piles);
            if(hours <= h){
                right = mid - 1;
                minBananas = Math.min(minBananas, mid);
            }else{
                left = mid +1;
            }
        }

        return minBananas;
    }
}
