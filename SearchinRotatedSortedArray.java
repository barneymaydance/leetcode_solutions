//O(log(n)) time
//O(1) space

public class Solution {
    public int search(int[] A, int target) {
        if(A==null||A.length==0){
            return -1;
        }
        int len= A.length;
        int left=0;
        int right=len-1;
        while(left<=right){
            int mid= (right-left)/2+left;
            if(A[mid]==target){
                return mid;
            }
            if(A[left]<=A[mid]){
                if(target<A[mid]&&target>=A[left]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{   //A[left]>A[mid]
                if(target>A[mid]&&target<=A[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}