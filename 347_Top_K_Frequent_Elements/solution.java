class Solution {
    // Time: O(n);
    // Space: O(n);
    public int[] topKFrequent(int[] nums, int k) {
        // if k = nums length, return nums
        if (k == nums.length) return nums;
        
        // Get the frequency of the data using HashMap
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Create nums length number of buckets to sort all values in the nums array.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i=0; i<buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int num: counter.keySet()) {
            buckets[counter.get(num)].add(num);
        }

        // Create a sorted array by extracting the sorted values from the bucket
        List<Integer> sorted = new ArrayList<>();
        for (int i=buckets.length-1; i>0; i--) {
            for (int num : buckets[i]) {
                sorted.add(num);
            }
        }

        // Create the answer array by extracting the first k elements from the sorted array
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = sorted.get(i);
        }

        return ans;
    }
}