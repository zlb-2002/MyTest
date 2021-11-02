package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute {
    /*  ȫ����
    ȫ���� ��Ҫ�ҵ�ÿһ�����з�ʽ����Ҫ�оٳ�ÿһ�������ȫ������Ҫ�ҵ�ÿһ�����з�ʽ�����Ծ�Ҫ�ҵ�һ�����з�ʽ֮����л��ݣ�������һ�����з�ʽ��
    ȫ���о��Ǻܵ��͵������㷨�����ҵ����з�ʽ���ڽ��л��ݡ�
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
