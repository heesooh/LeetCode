int search(int* nums, int numsSize, int target) {
    int left = 0;
    int right = numsSize-1;

    // binary loop
    while (right >= left) {
        int mid = (left + right)/2;

        if (nums[mid] == target) {
            return mid;
        }

        // if we're in the left sorted array, 
        if (nums[left] <= nums[mid]) {
            // if target is greater than the mid elem
            // or less than the left elem; left = mid+1
            // otherwise; right = mid-1
            if (target > nums[mid] || target < nums[left]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        // if we're in the right sorted array
        } else {
            // if target is less than the mid elem
            // or greater than the right elem; right = mid-1
            // otherwise; left = mid+1
            if (target < nums[mid] || target > nums[right]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
    }

    return -1;
}