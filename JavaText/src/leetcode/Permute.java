package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute {
    /*  全排列
    全排列 需要找到每一种排列方式，需要列举出每一种情况。全排列需要找到每一种排列方式，所以就要找到一种排列方式之后进行回溯，再找下一种排列方式。
    全排列就是很典型的深搜算法，当找到排列方式后在进行回溯。
     */


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0)  return list;
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        myPermute(list, nums, 0, path, used);
        return list;
    }
    public void myPermute (List<List<Integer>> list, int[] nums, int depth, Stack<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.push(nums[i]);
            used[i] = true;
            myPermute(list, nums, depth+1, path, used);
            path.pop();
            used[i] = false;
        }
    }

}
