"""
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l = ListNode()
        curr = l
        carry = 0
        pos1 = l1
        pos2 = l2

        while(pos1 or pos2):
            if (pos1 != None):
                p1 = pos1.val
            else:
                p1 = 0
            if (pos2 != None):
                p2 = pos2.val
            else:
                p2 = 0
            s = carry + p1 + p2
            carry = s // 10
            curr.next = ListNode(s % 10)
            curr = curr.next
            if (pos1 != None): pos1 = pos1.next
            if (pos2 != None): pos2 = pos2.next

        if (carry > 0):
            curr.next = ListNode(1)

        return l.next
