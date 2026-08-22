class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int x = n;
        while(x > 0){
            int lastDigit = x % 10;
            sum += lastDigit;
            product *= lastDigit;
            x /= 10;
        }
        if(n % (sum + product) == 0){
            return true;
        }
        return false;
    }
}