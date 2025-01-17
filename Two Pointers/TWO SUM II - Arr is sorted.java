// =========================== //Brute Force // ======================== //
// nested loops - check sum is equal to target if yes then store else j-- / i++
//TC: O(n^2)
//SC: O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans [] = new int[2];
        for(int i = 0; i<numbers.length ;i++){
            for(int j = i+1; j<numbers.length ;j++){
                if(numbers[i]+numbers[j] == target)
{
                    ans[0] = i+1;
                    ans[1] = j+1;
                    
}            }
        }
        return ans;
    }
}
// =========================== // Optimized // ======================== //
// Create ans arr - two pointer method - return ans
//TC: O(n)
//SC: O(1) use only two integer and 2 size array
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans [] = new int[2];
        int i = 0; 
        int j = nums.length - 1;
        while(i<j){
            //check 
            if(nums[i] + nums[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }else if(nums[i] + nums[j] > target){
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }
}
