class Solution {
    // Time: O(N * N); For each value iterate from the beginning to the current index.
    // Space: O(N);
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}