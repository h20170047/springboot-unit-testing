package com.svj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallestInBSTTest {
    @Test
    public void testKthSmallestInBST(){
        KthSmallestInBST smallest= new KthSmallestInBST();
        TreeNode root= new TreeNode(Arrays.asList(3,1,4,null,2));
        int actual= smallest.kthSmallest(root, 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testKthSmallestInBSTTest2(){
        KthSmallestInBST smallest= new KthSmallestInBST();
        TreeNode root= new TreeNode(Arrays.asList(5,3,6,2,4,null,null,1));
        int actual= smallest.kthSmallest(root, 3);
        assertThat(actual).isEqualTo(3);
    }

}