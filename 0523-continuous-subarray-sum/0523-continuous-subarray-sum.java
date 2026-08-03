class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        //map -> (remainder, index)
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int prefixSum = 0;

        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            int remainder = (k == 0)? prefixSum : prefixSum % k;

            if(map.containsKey(remainder)){
                if(i - map.get(remainder) >= 2){
                    return true;
                }
            }else{
                map.put(remainder,i);
            }
        }
        return false;
    }
}