//O(n) time	
//O(n) space
//use a hashset to store the array, then use contains(), remove() 
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num==null||num.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<num.length;i++){
            set.add(num[i]);
        }
        int maxLength=0;
        for(int i=0;i<num.length;i++){
            int len=0;
            int target=num[i];
            while(set.contains(target)){
                set.remove(target);
                len++;
                target++;
            }
            target=num[i];
            while(set.contains(target-1)){
                set.remove(target);
                len++;
                target--;
            }
            maxLength=Math.max(len,maxLength);
        }
        return maxLength;
    }
}