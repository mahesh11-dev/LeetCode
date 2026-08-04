class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }
        for(int j=min+1; j<=max-1; j++){
            if(!set.contains(j)){
                list.add(j);
            }
        }
        return list;
    }
}