package com.lesssoda.leetcode;

import java.util.*;

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
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dp(nums, 0, new boolean[nums.length]);
        return res;
    }
    private void dp(int[] nums, int cur, boolean[] visited) {
        if(cur == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(!(cur != 0 && nums[cur] == nums[cur - 1] && !visited[cur - 1])) {
            visited[cur] = true;
            temp.add(nums[cur]);
            dp(nums, cur + 1, visited);
            temp.remove(temp.size() - 1);
            visited[cur] = false;
        }

        dp(nums, cur + 1, visited);
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt += extend(s, i, i);
            cnt += extend(s, i, i + 1);
        }
        return cnt;
    }
    private int extend(String s, int l, int r){
        int cnt = 0;
        if(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int matR = mat.length;
        int matC = mat[0].length;
        if(matR * matC != r * c)    return mat;
        for(int i = 0; i < matR; i++){
            for(int j = 0; j < matC; j++){
                int idx = i * matC + j;
                res[idx / c][idx % c] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
//        System.out.println(new Solution().subsetsWithDup(new int[]{1,2,2}));
//        System.out.println(new Solution().countSubstrings("aaa"));
//        System.out.println(new Solution().matrixReshape(new int[][]{{1},{2},{3},{4}}, 2, 2));
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
