package com.svj.leetcode;

import java.util.List;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(TreeNode l, TreeNode r, Integer v){
        left= l; right= r; val= v;
    }
    TreeNode makeNewTree(List<Integer> values, int pos){
        if(pos< values.size() && values.get(pos)!= null){
            TreeNode left= makeNewTree(values, 2*pos+1);
            TreeNode right= makeNewTree(values, 2*pos+2);
            Integer val= values.get(pos);
            TreeNode root= new TreeNode(left, right, val);
            return root;
        }else{
            return null;
        }
    }
    TreeNode(List<Integer> values){
        TreeNode root=  makeNewTree(values, 0);
        left= root.left; right= root.right; val= root.val;
    }
}
