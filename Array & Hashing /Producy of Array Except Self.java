// ===============================// BRUTE FORCE // =====================//
// use 2 for loops - declare prod as 1 - add prod in res - return res
// TC: O(N^2) 
// SC: O(1) // output array exclueded from space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        
        
        for(int i = 0; i<n; i++){
            int prod = 1;//after i++ it resets to 1
            for(int j = 0; j<n ;j++){
                //if i == j skip
                if(i!=j){
                    prod *= nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
}
// ===============================// constant space // =====================//
// Approach-3 (Using constant space)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }
}
