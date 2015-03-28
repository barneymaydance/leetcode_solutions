//O(n) runtime
//O(1) space
// first find the digit from the behind to front, i, then find bigger j, swap, then reverse sequence after index j.
// if not exist reverse whole
 

public class Solution {
    public void nextPermutation(int[] num) {
        if(num==null||num.length<2)
            return;
        int len=num.length;
        for(int i=len-2;i>=0;i--){
            if(num[i+1]>num[i]){
                int j;
                for(j=len-1;j>i;j--){
                    if(num[j]>num[i]){
                        break;
                    }
                }
                swap(num,i,j);
                reverse(num,i+1,len-1);
                return;
            }
        }
        reverse(num,0,len-1);
    }
    
    private void swap(int[] num, int i, int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    
    private void reverse(int[] num, int beg, int end){
        for(int i=beg,j=end; i<j ; i++, j--){
            swap(num,i,j);
        }
    }
    
    
}