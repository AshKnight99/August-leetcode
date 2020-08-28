/**
Numbers With Same Consecutive Differences
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
You may return the answer in any order.
Example 1:
Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:
Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Note:
1 <= N <= 9
0 <= K <= 9
*/
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
       if (N == 1)
           return new int[]{0,1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i < 10;i++)
            DFS(N - 1,K,i,list);
        return list.stream().mapToInt(i -> i).toArray();           
        
    }
    private void DFS(int N,int K,int num,List<Integer> list){
        if(N == 0){
            list.add(num);
            return;
        }
        List<Integer> l = new ArrayList<>();
        int tail = num % 10;
        l.add(tail + K);
        if(K != 0)
            l.add(tail - K);
        for (int next : l){
            if(0 <= next && next < 10){
                int newNum = num * 10 + next;
                DFS(N - 1,K,newNum,list);
            }
        }
    }
}
/*
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {        
        if (N == 1) {
            return new int[]{1,2,3,4,5,6,7,8,9,0};
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(N-1, K, res, i);
        }
        
        int r[] = new int[res.size()];
        int pos = 0;
        for (int val : res) {
            r[pos++] = val;
        }
        return r;
    }
   private void solve(int N, int K, List<Integer> res, int currNum) {
        
        if (N == 0) {
            res.add(currNum);
            return;
        }
        
        if (K != 0 && currNum%10+K <= 9) {
                solve(N-1, K, res, currNum*10+currNum%10+K);
            }            
            if (currNum%10-K >= 0) {
                solve(N-1, K, res, currNum*10+currNum%10-K);
            }
        }        
}
*/