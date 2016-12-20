/**
 * Created by 曹利航 on 2016/10/17 10:34.
 */
public class Josephus {
    public static void main(String[] args) {
        int[] order = josephus(8, 3);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
        System.out.println();
    }

    public static int[] josephus(int n, int m) {
        // 为约瑟夫环创建循环链表
        ListNode header = new ListNode(1);
        ListNode current = header;
        for (int i = 2; i <= n; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        // 首尾相连
        current.next = header;

        // 开始数
        int[] order = new int[n];
        int index = 0;
        current = header;
        while (!current.next.equals(current)) { // 结束条件：只剩一个
            int i = 1;
            while (i < m - 1) {
                current = current.next;
                i++;
            }

            // 剔除报m的人
            if (i == m - 1) {
                order[index++] = current.next.person;
                current.next = current.next.next;
                current = current.next;
            }
        }
        // 在顺序中加入最后一个人
        order[index] = current.person;

        return order;
    }
}

class ListNode {
    int person;
    ListNode next;

    public ListNode(int person) {
        this.person = person;
        next = null;
    }
}
