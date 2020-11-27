package StackAndQueue;

import java.util.*;

public class TwoStackSort {
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<>();
        helper(s1, s2);
    }

    private void helper(LinkedList<Integer> s1, LinkedList<Integer> s2) {
        while (!s1.isEmpty()) {
            int globalMin = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                Integer ele = s1.pollLast();
                if (ele < globalMin) {
                    globalMin = ele;
                    count = 1;
                }else if (ele == globalMin) {
                    count++;
                }
                s2.offerLast(ele);
            }

            while(!s2.isEmpty() && s2.peekLast() >= globalMin) {
                Integer ele = s2.pollLast();
                if (ele != globalMin) {
                    s1.offerLast(ele);
                }
            }
            while(count != 0) {
                s2.offerLast(globalMin);
                count--;
            }
        }
        while(!s2.isEmpty()) {
            s1.offerFirst(s2.pollLast());
        }

    }

}
