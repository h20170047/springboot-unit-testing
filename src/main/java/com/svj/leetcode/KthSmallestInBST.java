package com.svj.leetcode;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list= new LinkedList<>();
        list= getInOrder(root);
        return list.get(k-1);
    }

    private List<Integer> getInOrder(TreeNode root) {
        if(root== null)
            return null;
        List<Integer> result= new LinkedList<>();
        if(root.left!= null) {
            List<Integer> left = getInOrder(root.left);
            if (left != null)
                result.addAll(left);
        }
        result.add(root.val);
        if(root.right!= null){
            List<Integer> right= getInOrder(root.right);
            if(right!= null)
                result.addAll(right);
        }
        return result;
    }
}
