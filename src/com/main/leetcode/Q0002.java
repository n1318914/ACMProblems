/*
 * 文件名：Q0002.java
 * 版权：Copyright by www.ixuenong.com
 * 描述：
 */

package com.main.leetcode;

import java.math.BigDecimal;
import java.math.MathContext;

public class Q0002
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal l = reverse(l1).add(reverse(l2));
        if(l.compareTo(new BigDecimal(0)) == 0) 
        {
            return new ListNode(0);
        }
        ListNode node = sort(null, l);
        
        return node;
    }
    
    public static ListNode sort(ListNode node,BigDecimal l)
    {
        if(l.compareTo(new BigDecimal(0)) == 0)
        {
            return node;
        }
        int lenth = l.toString().length();
        if(lenth > 0)
        {
            BigDecimal[] divideAndRemainder = l.divideAndRemainder(new BigDecimal(10));
            if(null == node)
            {
                node = new ListNode(divideAndRemainder[1].intValue());
                sort(node, divideAndRemainder[0]);
            }
            else
            {
                node.next = new ListNode(divideAndRemainder[1].intValue());
                if(divideAndRemainder[0].compareTo(new BigDecimal(0)) != 0)
                {
                    sort(node.next, divideAndRemainder[0]);
                }
            }
        }
        return node;
    }
    public static BigDecimal reverse(ListNode l)
    {
        String str="";
        while(null != l.next)
        {
            str = l.val + str;
            l = l.next;
        }
        str = l.val + str;
        return new BigDecimal(str);
    }
    public static void main(String[] args)
    {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);
//        ListNode l13 = new ListNode(6);
        l11.next = l12;
//        l12.next = l13;
        
        
        
        ListNode l21 = new ListNode(0);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;
        
        ListNode l = addTwoNumbers(l11,l21);
        
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }