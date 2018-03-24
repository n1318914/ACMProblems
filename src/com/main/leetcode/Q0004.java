/*
 * 文件名：Q0004.java
 * 版权：Copyright by www.ixuenong.com
 * 描述：
 */

package com.main.leetcode;


import java.util.Arrays;


/**
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * 解题关键：  找出第n小的数
 * 
 * @author yulong.chen@dfs168.com
 * @since 2018年3月24日
 */
public class Q0004
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0)
        {
            return (findK(nums1, nums2, length / 2) + findK(nums1, nums2, length / 2 + 1)) / 2.0;
        }
        else
        {
            return findK(nums1, nums2, (length + 1) / 2);
        }
    }

    public static int findK(int[] A, int[] B, int k)
    {
        int lenA = A.length;
        int lenB = B.length;
        if (lenA > lenB)
        {
            return findK(B, A, k);
        }
        if (lenA == 0)
        {
            return B[k - 1];
        }
        if (k == 1)
        {
            return Math.min(A[0], B[0]);
        }
        int pa = Math.min(k / 2, A.length), pb = k - pa;
        if (A[pa - 1] <= B[pb - 1])
        {
            return findK(Arrays.copyOfRange(A, pa, A.length), B, pb);
        }
        else
        {
            return findK(A, Arrays.copyOfRange(B, pb, B.length), pa);
        }

    }

    public static void main(String[] args)
    {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
