package com.lesssoda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lee
 * @since 2021/4/26 20:38
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1)
            return -1;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int res = 1;
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while(size-- > 0){
                int[] cur = queue.poll();
                for(int[] d : direction){
                    int[] child = new int[]{cur[0] + d[0], cur[1] + d[1]};
                    if(check(grid, child[0], child[1])){
                        if(child[0] == m - 1 && child[1] == n - 1)
                            return res;
                        grid[child[0]][child[1]] = 1;
                        queue.add(child);
                    }
                }
            }
        }
        return -1;
    }
    private boolean check(int[][] grid,int row,int col){
        if(row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length || grid[row][col] == 1)
            return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
