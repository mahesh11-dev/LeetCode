class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0) + 1);

            while(map.get(nums[j]) > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}