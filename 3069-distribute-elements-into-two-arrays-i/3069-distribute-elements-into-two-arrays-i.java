class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int lastArr1 = -1;
        int lastArr2 = -1;
        for(int i=0; i<n; i++){
            if(arr1.size() == 0){
                arr1.add(nums[i]);
                lastArr1 = nums[i];
            }else if(arr2.size() == 0){
                arr2.add(nums[i]);
                lastArr2 = nums[i];
            }else if(lastArr1 > lastArr2){
                arr1.add(nums[i]);
                lastArr1 = nums[i];
            }else{
                arr2.add(nums[i]);
                lastArr2 = nums[i];
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        for(int i=0; i<arr1.size(); i++){
            ans[idx++] = arr1.get(i);
        }
        for(int i=0; i<arr2.size(); i++){
            ans[idx++] = arr2.get(i);
        }
        return ans;
    }
}