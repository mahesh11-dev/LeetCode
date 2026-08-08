class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        int k = m - 1;
        for(int i=n-1; i>=0; i--){
            if(k >= 0 && word1.charAt(i) == word2.charAt(k)){
                last[k] = i;
                k--;
            }
        }
        //ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[m];
        int count = 0;
        boolean changed = false;
        int j = 0;
        for(int i=0; i<n && j<m; i++){
            if(word1.charAt(i) == word2.charAt(j)){
                ans[count++] = i;
                j++;
            }else{
                if(!changed && (j == m-1 || last[j+1] > i)){
                    ans[count++] = i;
                    changed = true;
                    j++;
                }
            }
        }
        // if(list.size() != m){
        //    return new int[0];
        // }
        
        // for(int i=0; i<list.size(); i++){
        //     ans[i] = list.get(i);
        // }
        return count == m ? ans : new int[0];
    }
}