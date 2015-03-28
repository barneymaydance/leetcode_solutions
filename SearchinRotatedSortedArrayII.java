//O(n) time
//O(1) space

public class Solution {
    public boolean search(int[] A, int target) {
        int left=0;
        int right=A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(A[mid]==target){
                return true;
            }
            else if(A[mid]>A[left]){
                if(target<A[mid]&&target>=A[left]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else if(A[mid]<A[left]){
                if(target>A[mid]&&target<=A[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            else{
                left++;
            }
        }
        return false;
    }
}