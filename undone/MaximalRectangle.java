//O(m*n) time
//O(n) space
//similar to Largest Rectangle in Histogram
//
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int maxArea=0;
        int[] heights= new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    heights[j]=0;
                }
                else{
                    heights[j]+=1;
                }
            }
            LinkedList<Integer> stack = new LinkedList<Integer>();
            for(int j=0;j<=heights.length;j++){
                int bar=j==heights.length?-1:heights[j];
                while(!stack.isEmpty()&&bar<=heights[stack.peek()]){
                    int h=heights[stack.pop()];
                    int w=stack.isEmpty()?j:j-stack.peek()-1;
                    maxArea=Math.max(maxArea,h*w);    
                }
                stack.push(j);
            }
        }
        return maxArea;
        
    }
}