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
        if(points == null || points.length == 0)
            return 0;
            
        HashMap<Float, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < points.length; i++) {
            map.clear();
            int same = 0;
            int max = 0;
            for(int j = 0; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                } else {
                    float k = (float)((points[j].y - points[i].y) * 1.0 / (points[j].x - points[i].x));
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 1);
                    }    
                    max = Math.max(max, map.get(k));
                }
                ans = Math.max(ans, max + same);
            }
            
        }
        return ans;
    }
}