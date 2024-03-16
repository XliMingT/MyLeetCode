package com.leetcode.lcr.t0025;

/**
 *
 * @author XliMing
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //获取数据长度
        int l1Len = getListNodeLen(l1);
        int l2Len = getListNodeLen(l2);
        //计算最长的数据长度
        int max = Math.max(l1Len, l2Len)+1;

        //这里是给数据补充长度（所有长度都补充成最大长度+1），类似 412 补充成 0412
        ListNode newL1 = replenishZeros(max-l1Len, l1);
        ListNode newL2 = replenishZeros(max-l2Len, l2);

        //最终返回的长度
        ListNode newHead = new ListNode();

        //进行添加递归
        add(newL1, newL2, newHead);

        //清理多余的0并且返回结果
        return cleanUpExcessZeros(newHead);
    }

    /**
     * 获取链表的长度
     * @param l 链表
     * @return 长度
     */
    private int getListNodeLen(ListNode l) {
        int len = 0;
        ListNode now = l;
        while (now != null) {
            len++;
            now = now.next;
        }
        return len;
    }

    /**
     * 补充多余的0
     * @param len 长度
     * @param l 原列表
     * @return 补充后的列表
     */
    private ListNode replenishZeros(int len, ListNode l) {
        ListNode newL = null;
        for (int i=0; i<len; i++) {
            ListNode node = new ListNode(0);
            if (i == 0) {
                node.next = l;
            } else {
                node.next = newL;
            }
            newL = node;
        }
        return newL;
    }

    /**
     * 最新的添加
     * @param a 左数据
     * @param b 右数据
     * @param now 新链表的当前值
     * @return 进位
     */
    private int add(final ListNode a, final ListNode  b,  ListNode now){
        //判空
        if (a == null || b == null) {
            return -1;
        }
        //给下一个值做一个默认值
        now.next = new ListNode(0);
        //获取低一位的进位【递归进入点】
        int c = add(a.next, b.next, now.next);
        //如果是异常结果做异常处理
        if (c == -1) {
            now.next = null;
            c = 0;
        }
        //做最终值的相加
        int value = a.val + b.val + c;

        now.val = value % 10;
        return value / 10;

    }

    /**
     * 清理多余的0
     * @param l 链表
     * @return 新的链表
     */
    private ListNode cleanUpExcessZeros(ListNode l) {
        while (l.val == 0) {
            if (l.next != null){
                l = l.next;
            } else {
                break;
            }
        }
        return l;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(3, new ListNode(7)));
//        ListNode l2 = new ListNode(6, new ListNode(3));
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        print(l1);
        print(l2);
        ListNode node = new Solution().addTwoNumbers(l1, l2);
        print(node);
    }

    /**
     * 打印链表
     * @param l 链表
     */
    private static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println();
    }
}




