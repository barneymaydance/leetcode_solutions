//O(n) runtime
//O(1) space

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
            res+=(bits[i]%2)<<i;
        }
        return res;
    }
}
        
//better solution	
public class Solution {
    public int singleNumber(int[] A) {
        if(A==null||A.length==0)
            return -1;
        int res = A[0];
        for(int i=1;i<A.length;i++)  
        {  
            res ^= A[i];  
        }  
        return res;
    }
}
        	