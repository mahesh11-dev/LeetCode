class Solution {
    public static int atMostK(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int i=0, j=0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while(map.size() > k){
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);             
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }

            if(map.size() <= k){
                count += (j - i + 1);
            }
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums, k-1);
    }
}