class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i=1; i<=100; i++){
            if(!set.contains(i*k)){
                return i*k;
            }
        }
        return n+1;
    }
}