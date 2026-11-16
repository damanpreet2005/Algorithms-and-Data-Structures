class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            maxFreq = Math.max(count[s.charAt(i) - 'A'], maxFreq);
            int repeated = (i - left) + 1 - maxFreq;

            while (repeated > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                repeated = (i - left) + 1 - maxFreq;
            }

            maxLen = Math.max(i - left + 1, maxLen);
        }

        return maxLen;
    }
}