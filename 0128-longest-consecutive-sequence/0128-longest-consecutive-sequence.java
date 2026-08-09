class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                count = 1;
                int curr = num;
                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}