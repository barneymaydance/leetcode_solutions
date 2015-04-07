//O(log(n))
//O(1)
//binary search

public class Solution {
    public int findMin(int[] num) {
        if(num==null||num.length==0){
            return 0;
        }
        int left=0;
        int right=num.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(num[right]>num[left]){
                return num[left];
            }
            else if(num[mid]>num[left]){
                left=mid+1;
            }
            else if(num[mid]==num[left]){
                left=num[mid]>num[mid+1]?mid+1:mid;    
            }
            else{
                right=mid;
            }
        }
        return num[left];
    }
}