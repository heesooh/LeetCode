class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        // The logic is entirely the same as
        // question 191. Number of 1 Bits
        // n-1 would flip the least significant bit of n,
        // thus we repeat n AND n-1 until n becomes 0 to find
        // the total number of 1(s) in the binary representaion. 
        for (int i = 0; i<=n; i++) {
            int curr = i;
            int counter = 0;
            while (curr != 0) {
                counter++;
                curr = (curr & curr-1);
            }
            ans[i] = counter;
        }

        return ans;
    }
}