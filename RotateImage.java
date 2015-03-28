//O(n^2) runtime  , the size of the matrix
//O(1) space


public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix==null||matrix.length<=1){
            return;
        }
        int n=matrix.length;
        int d=0;
        while(d<n/2){
            int capacity=n-2*d-1;
            for(int i=0;i<capacity;i++){
                int temp=matrix[d][i+d];
                matrix[d][i+d]=matrix[n-d-i-1][d];
                matrix[n-d-i-1][d]=matrix[n-d-1][n-d-i-1];
                matrix[n-d-1][n-d-i-1]=matrix[d+i][n-d-1];
                matrix[d+i][n-d-1]=temp;
            }
            d++;
        }
    }
}