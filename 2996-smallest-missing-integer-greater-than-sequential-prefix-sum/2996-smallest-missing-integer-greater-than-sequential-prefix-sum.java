class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int prefixSum = nums[0];
        for(int j=1; j<n; j++){
            if(nums[j] == nums[j - 1] + 1){
                prefixSum += nums[j];
            }else{
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(set.contains(prefixSum)){
            prefixSum++;
        }
        return prefixSum;
    }
}