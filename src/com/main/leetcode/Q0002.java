/*
 * 文件名：Q0002.java
 * 版权：Copyright by www.ixuenong.com
 * 描述：
 */

package com.main.leetcode;

/**
 * 
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * @author yulong.chen@dfs168.com
 * @since 2018年3月20日
 */
public class Q0002
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = l1,q = l2,curr = head;
        
        while(null != p || null!= q)
        {
            int x = null != q ? q.val : 0;
            int y = null != p ? p.val : 0;
            int z = x + y + carry;
            curr.next = new ListNode(z % 10);
            carry = z / 10;
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry > 0)
        {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
    
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }