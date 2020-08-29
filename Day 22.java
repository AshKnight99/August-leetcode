/*
 Random Point in Non-overlapping Rectangles
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
Note:
An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:
Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:
Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:
The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*/
class Solution {
    TreeMap <Integer,int[]> map;
    int areaSum;
    Random rand;
    public Solution(int[][] rects) {
        areaSum = 0;
        rand = new Random();
        map = new TreeMap<>();
        for(int []rectscord:rects){
            int length = rectscord[2] - rectscord[0] + 1;
            int breadth = rectscord[3] - rectscord[1] + 1;            
            areaSum += (length * breadth);
            map.put(areaSum,rectscord);
        }        
    }    
    public int[] pick() {
        int key = map.ceilingKey(rand.nextInt(areaSum) + 1);
        int rect[] = map.get(key);
        int length = rect[2] - rect[0] + 1;
        int breadth = rect[3] - rect[1] + 1;
        int x = rect[0] + rand.nextInt(length);
        int y = rect[1] + rand.nextInt(breadth);
        return new int[]{x,y};       
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */