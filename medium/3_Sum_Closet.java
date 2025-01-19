class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int res = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i=0; i<n-2; i++) {
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If sum matches target, it's the closest possible sum
                if (sum == target) return target;

                // If this sum is closer to the target, update res
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    res = sum;
                }

                // Move the pointers accordingly
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
