//O(log(n)) runtime
//O(1) space
// when it stop, left value is always the bigger one (compared to right value)


public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A==null&&A.length==0)
            return 0;
        int len= A.length;
        int l=0;
        int r=len-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(A[mid]==target){
                return mid;
            }
            if(A[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}