package org.example.AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */


public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l111 = new ListNode(1);
        ListNode l11 = new ListNode(2, l111);
        ListNode l1 = new ListNode(3, l11);

        ListNode l222 = new ListNode(1);
        ListNode l22 = new ListNode(2, l222);
        ListNode l2 = new ListNode(3, l22);

        solution(l1, l2);

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return new ListNode(-1);
        }
        List<Integer> ll1 = new ArrayList();
        ListNode currentNode = l1;
        while(currentNode != null) {
            ll1.add(currentNode.val);
            currentNode = currentNode.next;
        }

        StringBuilder num1StrB = new StringBuilder(64);
        while (!ll1.isEmpty()){
            int digit = ll1.get(ll1.size()-1);
            ll1.remove(ll1.size()-1);
            num1StrB.append(digit);
        }
        int num1 = Integer.valueOf(num1StrB.toString());

        List<Integer> ll2 = new ArrayList();
        currentNode = l2;
        while(currentNode != null) {
            ll2.add(currentNode.val);
            currentNode = currentNode.next;
        }
        StringBuilder num2StrB = new StringBuilder(64);
        while (!ll2.isEmpty()){
            int digit = ll2.get(ll2.size()-1);
            ll2.remove(ll2.size()-1);
            num2StrB.append(digit);
        }
        int num2 = Integer.valueOf(num2StrB.toString());
        int sum = num1+num2;

        ListNode answerBuild = new ListNode();
        ListNode answer = answerBuild;
        while (sum > 0) {
            answerBuild.val = sum % 10;
            answerBuild.next = new ListNode();
            answerBuild = answerBuild.next;
            sum = sum / 10;
        }
        return answer;


    }


}
