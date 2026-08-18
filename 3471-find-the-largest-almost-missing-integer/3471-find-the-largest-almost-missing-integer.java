class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < n){
            int size = j - i + 1;
            if(size == k){
                HashSet<Integer> set = new HashSet<>();
                for(int l=i; l<=j; l++){
                    set.add(nums[l]);
                }
                for(int x : set){
                    map.put(x, map.getOrDefault(x,0)+1);
                }
                i++;
            }
            j++;
        }
        int largest = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key > largest && value == 1){
                largest = key;
            }
        }
        return largest;
    }
}