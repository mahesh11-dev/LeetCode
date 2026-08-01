import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(prefixSum,1);
        int count = 0;
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            int rem = prefixSum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}