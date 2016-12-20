/**
 * Created by 曹利航 on 2016/10/17 10:04.
 */
public class Addition {
    public static void main(String[] args) {

        LinkedList listA = new LinkedList();
        LinkedList listB = new LinkedList();

        LinkedListItr itrA = listA.zeroth();
        LinkedListItr itrB = listB.zeroth();

        itrA.current.next = new ListNode(new Data(2, 100));
        itrA.advance();
        itrA.current.next = new ListNode(new Data(3, 14));
        itrA.advance();
        itrA.current.next = new ListNode(new Data(2, 8));
        itrA.advance();
        itrA.current.next = new ListNode(new Data(1, 0));

        itrB.current.next = new ListNode(new Data(-2, 100));
        itrB.advance();
        itrB.current.next = new ListNode(new Data(8, 14));
        itrB.advance();
        itrB.current.next = new ListNode(new Data(-3, 10));
        itrB.advance();
        itrB.current.next = new ListNode(new Data(10, 6));
        itrB.advance();
        itrB.current.next = new ListNode(new Data(-1, 1));

        LinkedList res = Addition.addition(listA, listB);
        Addition.printList(res);

    }

    public static LinkedList addition(LinkedList listA, LinkedList listB) {
        LinkedList res = new LinkedList();

        LinkedListItr itrA = listA.first();
        LinkedListItr itrB = listB.first();
        LinkedListItr itr = res.zeroth();

        while (!itrA.isPastEnd() && !itrB.isPastEnd()) {
            if (itrA.retrieve().exp < itrB.retrieve().exp) {
                res.insert(itrB.current.data, itr);
                itrB.advance();
                itr.advance();
            } else if (itrA.retrieve().exp == itrB.retrieve().exp) {
                int exp = itrA.retrieve().exp;
                double coef = itrA.retrieve().coef + itrB.retrieve().coef;
                Data data = new Data(coef, exp);
                if (coef == 0.0) {  // 该项消去
                    itrA.advance();
                    itrB.advance();
                } else {
                    res.insert(data, itr);
                    itrA.advance();
                    itrB.advance();
                    itr.advance();
                }
            } else {
                res.insert(itrA.current.data, itr);
                itrA.advance();
                itr.advance();
            }
        }

        while (!itrA.isPastEnd()) {
            res.insert(itrA.current.data, itr);
            itr.advance();
            itrA.advance();
        }

        while (!itrB.isPastEnd()) {
            res.insert(itrB.current.data, itr);
            itr.advance();
            itrB.advance();
        }

        return res;
    }

    public static void printList(LinkedList theList) {
        if (theList.isEmpty())
            System.out.print("The list is empty.");
        else {
            LinkedListItr itr = theList.first();
            for (; !itr.isPastEnd(); itr.advance())
                System.out.println((int)itr.retrieve().coef + " " + itr.retrieve().exp);
        }
        System.out.println();
    }
}

class Data {
    int exp;
    double coef;

    Data(double coef, int exp) {
        this.exp = exp;
        this.coef = coef;
    }
}

class ListNode {
    Data data;
    ListNode next;

    ListNode(Data data) {
        this(data, null);
    }

    ListNode(Data data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedListItr {
    LinkedListItr(ListNode theNode) {
        current = theNode;
    }

    public boolean isPastEnd() {
        return current == null;
    }

    public Data retrieve() {
        return isPastEnd() ? null : current.data;
    }

    public void advance() {
        if (!isPastEnd())
            current = current.next;
    }

    ListNode current;
}

class LinkedList {

    private ListNode header;

    public LinkedList() {
        header = new ListNode(null);
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
    }

    public LinkedListItr zeroth() {
        return new LinkedListItr(header);
    }

    public LinkedListItr first() {
        return new LinkedListItr(header.next);
    }

    public LinkedListItr find(Data data) {
        ListNode itr = header.next;
        while (itr != null && !itr.data.equals(data))
            itr = itr.next;
        return new LinkedListItr(itr);
    }

    public void remove(Data data) {
        LinkedListItr p = findPrevious(data);
        if (p.current.next != null)
            p.current.next = p.current.next.next;
    }

    LinkedListItr findPrevious(Data data) {
        ListNode itr = header;
        while (itr.next != null && !itr.next.data.equals(data))
            itr = itr.next;
        return new LinkedListItr(itr);
    }

    void insert(Data data, LinkedListItr p) {
        if (p != null && p.current != null)
            p.current.next = new ListNode(data, p.current.next);
    }
}



