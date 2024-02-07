class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // sort the entire array; this allows move the left and right
        // pointers based on the total sum (explained below)
        Arrays.sort(nums);

        // iterate from the first element to the second last element
        // last two elements are covered by the left and right pointers
        for (int i=0; i<nums.length-2; i++) {
            // if current value is the same as the previous value
            // skip iteration to prevent repetition 
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            // initialize left and right pointers
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Add current tuple if sum = 0
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip repeating left and right values
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    // move pointers to the next value
                    left++;
                    right--;
                } else if (sum < 0) {
                    // increment left pointer if sum < 0
                    left++;
                } else {
                    // decrement right pointer if sum < 0
                    right--;
                }
            }
        }

        return res;
    }
}

