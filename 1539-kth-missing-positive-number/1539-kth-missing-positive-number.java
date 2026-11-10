class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int missCount = 0;
        int j = 0;
        for(int i=1; i<=arr[n-1]+k; i++){
            if(j < n && arr[j] == i){
                j++;
            }else{
                missCount++;
            }
            if(missCount == k){
                return i;
            }
            //int count = 0;
            // for(int j=0; j<n; j++){
            //     if(arr[j] == i){
            //         count++;
            //     }
            // }
            // if(count == 0){
            //     missCount++;
            //     if(missCount == k){
            //         return i;
            //     }
            // }
        }
        // for(int i=0; i<list.size(); i++){
        //     if(i+1 == k){
        //         return list.get(i);
        //     }
        // }
        return -1;
    }
}