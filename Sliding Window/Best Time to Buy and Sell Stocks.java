// ====================================== // Brute Force // ============================== //
// Approach : use two loops and sell - buy = profie store in max
//TC: O(n^2)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int max= 0;
        for(int i = 0; i<prices.length; i++){
            for(int j = i+1; j<prices.length; j++){
                max += Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
// ======================================== // Two Pointer // ========================== //
// Approach : use two pointer l at 0 , r at 1 return maxP
//TC : O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP,profit);
            }else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
