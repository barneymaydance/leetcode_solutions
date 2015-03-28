//O(log(n)+log(m)) time
//O(1) space
//use two binary searches

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int up=0;
        int down=n-1;
        while(up<=down){
            int mid=(up+down)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]<target&&target<=matrix[mid][m-1]){
                int left=0;
                int right=m-1;
                while(left<=right){
                    int central=(left+right)/2;
                    if(matrix[mid][central]==target){
                        return true;
                    }
                    else if(target>matrix[mid][central]){
                        left=central+1;
                    }
                    else{
                        right=central-1;
                    }
                }
                return false;
            }
            else if(target<matrix[mid][0]){
                down=mid-1;
            }
            else if(target>matrix[mid][m-1]){
                up=mid+1;
            }
        }
        return false;
    }
}


//O(log(m*n)) time
//O(1) space
//use one binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int r=m*n-1;
        while(l<=r){
            int mid=(l+r)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target>matrix[row][col]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}