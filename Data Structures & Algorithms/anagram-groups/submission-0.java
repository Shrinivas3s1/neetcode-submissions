class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] charat = new int[26];
            for(char c : str.toCharArray()){
                charat[c - 'a']++;
            }
            String Key = Arrays.toString(charat);
            map.putIfAbsent(Key, new ArrayList<>());
            map.get(Key).add(str);
        }  

        return new ArrayList<>(map.values());
        
    }
}
