class Solution {
    public int maxArea(int[] height) {
        // initialize left and right pointers
        // where left start from index 0 & right from index length-1
        int left = 0;
        int right = height.length-1;

        // initialize the maximum value integer
        int max = 0;
        int curr = 0;

        // while left is less than right
        // calculate current area: (right-left) * min(height[left], height[right]);
        // if current area is larger than the current max value, update
        while (left < right) {
            curr = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max, curr);

            // if height[left] < height[left+1]; left++
            // if height[right] < height[right-1]; right--
            // else left++

            // Mistake: rather comparight left and right pointers to
            // their adjacent height, we should put our focus on 
            // making sure that both left and right reach the highest
            // possible height value at the same time.
            // if (height[left+1] > height[left]) {
            //     left++;
            // } else if (height[right-1] > height[right]) {
            //     right--;
            // } else {
            //     left++;
            // }

            // Solution:
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
