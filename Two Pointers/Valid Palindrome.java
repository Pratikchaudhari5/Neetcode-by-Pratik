// ================================ // Brute Force // ========================= //
//TC: O(n) clean string O(n) + compare O(n) i.e. O(n)
//SC: O(n) storing reversed string
class Solution {
  public boolean isPalindrome(String s) {
    // 1. clean the string
    s = s.toLowerCase().replaceAll("[^a-z0-9]","");
    //2. reverse string 
    String reversed = "";
    for(int i = s.length() - 1; i >= 0; i--){
      reversed += s.charAt(i);
    }
    //3.compare
    return s.equals(reversed);
  }
}
// ================================ // Two Pointer // ========================= //
//TC: O(n) {Store lowercase O(n) + replaceAll() O(n) + compareO(n) } 3 O(n) i.e. O(n)
//SC: O(n) replace all method create new string
class Solution {
    public boolean isPalindrome(String s) {
       s= s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
        }
        return true;
    }
}
