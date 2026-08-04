class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            int remainder = ((prefixSum % k) + k) % k;
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}