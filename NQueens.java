//O(2^n) runtime?
//O(n) space
//NP-complete problem


public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res= new ArrayList<String[]>();
        if(n<=0){
            return res;
        }
        helper(n,0,new int[n],res);
        return res;
    }
    
    private void helper(int n,int row, int[] coloumIndexRow,List<String[]> res){
        if(n==row){
            String[] str=new String[n];
            for(int i=0;i<n;i++){
                StringBuilder strRow=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(j==coloumIndexRow[i]){
                        strRow.append('Q');
                    }
                    else{
                        strRow.append('.');  
                    }
                
                }
                str[i]=strRow.toString();
            }
            res.add(str);
            return;
            
        }
        
        for(int i=0;i<n;i++){
            coloumIndexRow[row]=i;
            if(isValid(row,coloumIndexRow)){
                helper(n,row+1,coloumIndexRow,res);
            }        
        }
    }
    
    private boolean isValid(int row,int[] coloumIndexRow){
        for(int i=0;i<row;i++){
            if((coloumIndexRow[i]==coloumIndexRow[row])||(Math.abs((coloumIndexRow[i]-coloumIndexRow[row]))==row-i)){
                return false;
            }
        }
        return true;
    }
    
}