class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1; 
        int high = position[n - 1] - position[0];
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(canPlace(position, mid, m, n)){
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean canPlace(int[] position, int mid, int m, int n){
        int count = 1;
        int lastIndex = position[0];

        for (int i = 1; i < n; i++) {
            if (position[i] - lastIndex >= mid) {
                count++;
                lastIndex = position[i];
            }
        }

        if (count < m){
            return false;
        }

        return true;
    }
}