package com.leetcode.t0025;

/**
 *
 * @author XliMing
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //获取数据长度
        int l1Len = getListNodeLen(l1);
        int l2Len = getListNodeLen(l2);
        int max = Math.max(l1Len, l2Len)+1;

        //
        ListNode newL1 = null;
        for (int i=0; i<max-l1Len; i++) {
            ListNode node = new ListNode(0);
            if (i == 0) {
                node.next = l1;
            } else {
                node.next = newL1;
            }
            newL1 = node;
        }

        ListNode newL2 = null;
        for (int i=0; i<max-l2Len; i++) {
            ListNode node = new ListNode(0);
            if (i == 0) {
                node.next = l2;
            } else {
                node.next = newL2;
            }
            newL2 = node;
        }

        ListNode newHead = new ListNode();

        add(newL1, newL2, newHead);

        while (newHead.val == 0) {
            if (newHead.next != null){
                newHead = newHead.next;
            } else {
                break;
            }
        }
        return newHead;
    }

    private int getListNodeLen(ListNode l) {
        int len = 0;
        ListNode now = l;
        while (now != null) {
            len++;
            now = now.next;
        }
        return len;
    }

    private int add(final ListNode a, final ListNode  b,  ListNode now){
        if (a == null || b == null) {
            return -1;
        }
        now.next = new ListNode(0);
        int c = add(a.next, b.next, now.next);
        if (c == -1) {
            now.next = null;
            c = 0;
        }
        int value = a.val + b.val + c;

        now.val = value % 10;
        return value / 10;

    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(3, new ListNode(7)));
//        ListNode l2 = new ListNode(6, new ListNode(3));
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode node = new Solution().addTwoNumbers(l1, l2);
        System.out.println();
    }
}




