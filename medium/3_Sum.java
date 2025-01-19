class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> result = new HashSet<>();

        if(n == 0 || n < 3) return new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int fixNum = nums[i];

            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = fixNum + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(fixNum, nums[left], nums[right]));
                    left++;
                    right--;
                }
                

                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
