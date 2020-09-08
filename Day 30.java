/*
Largest Component Size by Common Factor
Given a non-empty array of unique positive integers A, consider the following graph:
There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.
Example 1:
Input: [4,6,15,35]
Output: 4
Example 2:
Input: [20,50,9,63]
Output: 2
Example 3:
Input: [2,3,6,7,4,12,21,39]
Output: 8
Note:
1 <= A.length <= 20000
1 <= A[i] <= 100000
*/
class Solution {
    int parent[];
    public int largestComponentSize(int[] A) {
        int n = Arrays.stream(A).max().getAsInt();
        parent = new int[n + 1];
        for(int i = 0;i <= n;i++)
            parent[i] = i;
        //System.out.print(parent[n]);
        for(int i = 0;i < A.length;i++)
             checkPrimeParents(A[i]);           
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int a : A){
            int par = find(a);
            map.put(par,map.getOrDefault(par,0) + 1);
            max = Math.max(max,map.get(par));
        }          
        return max;        
    }
    private void checkPrimeParents(int num){
        for(int i = 2;i <= Math.sqrt(num);i++){
            if(num % i == 0){
                union(num,i);
                union(num,num / i);
            }
        }
    }
    private void union(int x,int y){
        parent[find(x)] = parent[find(y)];
    }
    private int find(int num){
        if(num != parent[num])
            parent[num] = find(parent[num]);
        return parent[num];
    }
}