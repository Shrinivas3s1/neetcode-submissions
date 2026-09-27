
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean output = false;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                 output = true;
            }

            map.put(nums[i], i);
        }
        return output;
    }
}