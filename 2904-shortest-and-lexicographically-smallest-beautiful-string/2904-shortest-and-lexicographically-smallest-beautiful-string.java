class Solution {
    private String checkLexicography(String resultStr, String str){
        if(resultStr.compareTo(str) < 0){
            return resultStr;
        }
        return str;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String resultStr = "";
        for(int i=0; i<n; i++){
            int count1 = 0;
            for(int j=i; j<n; j++){
                if(s.charAt(j) == '1'){
                    count1++;
                }
                if(count1 == k){
                    String str = s.substring(i, j+1);
                    if(resultStr.length() == 0 || str.length() < resultStr.length()){
                        resultStr = str;
                    }else if(resultStr.length() == str.length()){
                        resultStr = checkLexicography(resultStr, str);
                    }
                    break;
                }
            }
        }
        return resultStr;
    }
}