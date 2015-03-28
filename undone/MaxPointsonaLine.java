//O(n^2) time
//O(n) space
//use a hashtable, and set a pointer as a reference pointer
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null||points.length==0){
            return 0;
        }
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        int max=1;
        for(int i=0;i<points.length;i++){
            int dup=0;
            map.put(-Double.MAX_VALUE,1);
            for(int j=i+1;j<points.length;j++){
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    dup++;
                    continue;
                }
                double k=points[i].x-points[j].x==0?Double.MAX_VALUE:(double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x)+0.0;
                if(map.containsKey(k)){
                    map.put(k,map.get(k)+1);
                }
                else{
                    map.put(k,2);
                }
            }
            for(Integer temp:map.values()){
                if(temp+dup>max){
                    max=temp+dup;
                }
            }
            map.clear();
        }
        return max;
        
    }
}
