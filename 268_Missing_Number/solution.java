class Solution {
    // Time: O(N)
    // Space: O(1)
    public int missingNumber(int[] nums) {
        // Becuase XOR on two same value = 0
        // and we know that there is exactly one value missing
        // on the nums array, we can XOR all nums elements
        // to all index value from 0~n to find the missing value
        // e.g. 
        // =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
        // =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
        // =0∧0∧0∧0∧2
        // =2
        // i.e. XOR on all index [0~n] and all values in the array
        // all repeating values will cancel out to 0, and only the missing
        // will remain at the end of the loop
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Time: O(N)
    // Space: O(1)
    public int missingNumber_initial(int[] nums) {
        int ans = 0;
        for (int i=0; i<=nums.length; i++) {
            ans += i;
        }

        for (int num: nums) {
            ans -= num;
        }

        return ans;
    }

    // Time: O(N)
    // Space: O(1)
    public int missingNumber_bitManipulation(int[] nums) {
        int expected = 0;
        for (int i=0; i<=nums.length; i++) {
            expected ^= i;
        }

        int actual = 0;
        for (int num: nums) {
            actual ^= num;
        }

        return expected ^ actual;
    }

    // Time: O(N)
    // Space: O(N)
    public int missingNumber_set(int[] nums) {
        Set<Integer> allNums = new HashSet<>();

        for (int num: nums) {
            allNums.add(num);
        }

        for (int i=0; i<=nums.length; i++) {
            if (!allNums.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    // Time: O(NLogN) casued by sort
    // Space: O(logN) caused by sort
    public int missingNumber_sort(int[] nums) {
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}