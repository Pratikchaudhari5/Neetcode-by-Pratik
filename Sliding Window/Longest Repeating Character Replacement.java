// Time complexity: O(n2)
// Space complexity: O(m)
//BF
class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for(int i = 0; i<s.
            HashMap<Character,Integer> count = new HashMap<>();
            int maxF = 0;
            for(int j = i; j<s.length(); j++){
                count.put(s.charAt(j),count.getOrDefault(s.charAt(j),0) + 1);
                maxF = Math.max(maxF , count.get(s.charAt(j)));
                    //length - maxF = minF < k
                if((j-i+1) - maxF <=k)
{
    
    res = Math.max(res, j - i + 1);
}            }
        }
        return res;
    }
}
=====================================================================================
  class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;// start of window
        int maxF = 0; // max freq of any char in curr window
        int res =0; // res to store the long valid substring

        //Hashmap - store freq in window
        HashMap<Character,Integer> count = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            // expand the window by including the char at right
            char curr = s.charAt(right);
            count.put(curr, count.getOrDefault(curr,0)+1);

            //update maxF with high freq of any char in window
            maxF = Math.max(maxF, count.get(curr));

            //check if curr window is invalid
            while((right - left + 1) - maxF > k){
                // length - maxF 
                //shrink window from left
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar)-1);
                left++;
            }

            //update the res with the size of the valid window
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
