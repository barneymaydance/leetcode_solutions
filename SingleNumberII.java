//O(n) runtime
//O(1) space
//bit manipulation
//every element appears three times except for one. ------> every bit digit mod  3, get the single one bit digit
//consider all number bit by bit, count the occurrence of '1' in each bit

public class Solution {
    public int singleNumber(int[] A) {
        int[] bits=new int[32];
        
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                bits[i]+=(A[j]>>i)&1;
            }
        }
        int res=0;
        for(int i=0;i<32;i++){
            res+=(bits[i]%3)<<i;
        }
        return res;
    }
}

//modify by above
public class Solution {
    public int singleNumber(int[] A) {
        if(A==null||A.length==0)
            return -1;
        int[] bits=new int[32];
        int res=0;
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                bits[i]+=(A[j]>>i)&1;
            }
            res+=(bits[i]%3)<<i;
        }
        return res;
    }
}