class Solution {
    public boolean canEatAll(int[] piles, int mid, int h){
        long sum = 0;

        for (int pile : piles) {
            long count = ( pile + mid - 1 ) / mid;
            sum += count;
        }

        if( sum <= h ) {
            return true;
        }

        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, mid, h)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}