class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().getAsInt();

        int low = 1;
        int high = max;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(findMinimimEatingRate(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // for(int i = 1; i <= max; i++) {
        //     if(findMinimimEatingRate(i, piles, h)) {
        //         return i;
        //     }
        // }

        // return -1;

        return ans;
        
    }

    boolean findMinimimEatingRate(int k, int[] piles, int h) {

        for(int i : piles) {
            double di = i;
            double dk = k;
            double hoursNeeded = Math.ceil((di / dk));
            h = h - (int) hoursNeeded;

            if(h < 0) {
                return false;
            }
        }

        return true;
    }
}
