public class Solution {
    // Time: O(1)
    // Space: O(1)
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;

        for (int i=0; i<32; i++) {
            if ((n & mask) != 0) {
                ans = ans | 1;
            }
            if (i != 31) {
                ans = ans << 1;
                mask = mask <<1;
            }
        }

        return ans;
    }
}