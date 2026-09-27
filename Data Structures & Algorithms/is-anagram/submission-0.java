class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
        return false;
      }

      int[] charAt = new int[26];

      for(int i=0; i<s.length(); i++){
        charAt[s.charAt(i) - 'a']++;
        charAt[t.charAt(i) - 'a']--;
      }

      for(int n : charAt){
        if (n != 0){
        return false;
        }
      }
      return true;
    }
}
