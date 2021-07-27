package edu.leetcode.diyan;

import java.util.Optional;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3)));

        ListNode l2 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4)));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private ListNode current;
    private ListNode head;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int addition) {
        if (l1 == null && l2 == null) {
            if (addition == 1){
                appendToResult(1);
            }
            return head;
        }
        int firstNumber = Optional.ofNullable(l1).map(l -> l.val).orElse(0);
        int secondNumber = Optional.ofNullable(l2).map(l -> l.val).orElse(0);

        int digitToAppend = firstNumber + secondNumber + addition;

        if (digitToAppend > 9) {
            // append to sum a digit
            appendToResult(digitToAppend % 10);
            addTwoNumbers(
                    l1 != null ? l1.next : null,
                    l2 != null ? l2.next : null,
                    1
            );
        } else {
            // append to sum a digit
            appendToResult(digitToAppend);
            addTwoNumbers(
                    l1 != null ? l1.next : null,
                    l2 != null ? l2.next : null,
                    0
            );
        }

        return head;
    }

    private void appendToResult(int digitToAppend) {
        if (current == null) {
            current = new ListNode(digitToAppend);
            head = current;
        } else {
            current.next = new ListNode(digitToAppend);
            current = current.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
