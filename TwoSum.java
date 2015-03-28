//O(n) runtime, O(n) space 
// index are not zero-based

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] result= new int[2];
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        for (int i=0;i<numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                if(map.get(target-numbers[i])>(i+1)){
                    result[0]=i+1;
                    result[1]=map.get(target-numbers[i]);
                    return result;
                }
                else if(map.get(target-numbers[i])<(i+1)){
                    result[1]=i+1;
                    result[0]=map.get(target-numbers[i]);
                    return result;
                }
            }
        }
        
        return null;
    }
}