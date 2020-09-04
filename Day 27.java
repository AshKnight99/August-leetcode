/*
Find Right Interval
Given an array of intervals where intervals[i] = [starti, endi]. For each interval i, check if there exists an interval j where startj >= endi, which can be called that interval j is on the right of interval i.
For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "on the right of" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you should return the stored value of each interval as an array.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
Example 1:
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 Constraints:
1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start points of each interval is unique.
*/
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        if(n == 0 || m == 0)
            return new int[]{};
        TreeMap <Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i < n;i++)
            map.put(intervals[i][0],i);
        int arr[] = new int[n];
        int index = -1;
        for(int i = 0;i < n;i++){
            Map.Entry<Integer,Integer> entry = map.ceilingEntry(intervals[i][1]);       
            arr[i] = (entry != null) ? entry.getValue() : -1;
        }
        return arr;            
    }
} 