class Solution {
    private int digitProduct(int num){
        int product = 1;
        while(num != 0){
            int lastDigit = num % 10;
            product *= lastDigit;
            num = num / 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n; i<=100; i++){
            if(digitProduct(i) % t == 0){
                return i;
            }
        }
        return -1;
    }
}