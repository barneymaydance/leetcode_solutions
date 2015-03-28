//O(2^n) time
//O(2^n) space

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s==null||s.length()<4||s.length()>12){
            return res;
        }
        helper(s,res,new String(),0,0);
        return res;
    }
    
     private void helper(String s,List<String> res,String temp,int i,int segment){
        if(i>=s.length()||segment>4){
            if(segment==4&&temp.length()==s.length()+3){
        	    res.add(new String(temp));
            }
            return;
        }
        String str=s.substring(i,i+1);
        String or=new String(temp);
        if(temp.length()!=0){
            temp=temp+"."+str;
        }
        else{
            temp+=str;
        }
        helper(s,res,temp,i+1,segment+1);
        temp=or;
        if(i+2<=s.length()){
	        str=s.substring(i,i+2);
	        if(10<=Integer.parseInt(str)&&Integer.parseInt(str)<=99){
    	        if(temp.length()!=0){
                    temp=temp+"."+str;
                }
                else{
                    temp+=str;
                }
    	        helper(s,res,temp,i+2,segment+1);
    	        temp=or;
	        }
        }
        if(i+3<=s.length()){
	        str=s.substring(i,i+3);
	        if(100<=Integer.parseInt(str)&&Integer.parseInt(str)<=255){
    	        if(temp.length()!=0){
                    temp=temp+"."+str;
                }
                else{
                    temp+=str;
                }
	            helper(s,res,temp,i+3,segment+1);
	            temp=or;
	        }
        }
    }
}
