//O(n) time
//O(1) space

public class Solution {
    public static int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int idx=1;
        for(int i=1;i<A.length;i++){
            if(i==A.length-1){
                A[idx++]=A[i]; 
            }
            else if(!(A[i]==A[i-1]&&A[i+1]==A[i])){
                A[idx++]=A[i];    
            }
        }
        return idx;
    }
	
	//method 2
	public class Solution {
    public static int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int idx=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            if(i>0&&A[i]==A[i-1]){
                count++;
                if(count>=3){
                    continue;    
                }
            }
            else{
                count=1;
            }    
            A[idx++]=A[i];
        }
        return idx;
    }
}