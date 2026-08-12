class Solution {
    private List<Integer> generateRow(int row){
        ArrayList<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans);
        for(int col=1; col<row; col++){
            ans = ans * (row - col);
            ans = ans / col;
            temp.add(ans);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
}