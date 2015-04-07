//O(n) time
//O(1) space
//the Boyer-moore Majority vote algorithm
public class Solution {
    public int majorityElement(int[] num) {
        int res=num[0];
        int count=0;
        for(int i=0;i<num.length;i++){
            if(count==0){
                res=num[i];
            }
            if(num[i]==res){
                count++;
            }
            else{
                count--;
            }
        }
        return res;
    }
}

//sort (n(logn)), then get n[length/2] element