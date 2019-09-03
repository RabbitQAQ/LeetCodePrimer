package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution341 {
//    public class NestedIterator implements Iterator<Integer> {
//
//        List<Integer> res;
//        int count;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            this.res = new ArrayList<>();
//            this.count = 0;
//            helper(nestedList, res);
//        }
//
//        public void helper(List<NestedInteger> nestedList, List<Integer> res) {
//            for (int i = 0; i < nestedList.size(); i++) {
//                NestedInteger tmp = nestedList.get(i);
//                if (tmp.isInteger()) {
//                    res.add(tmp.getInteger());
//                } else {
//                    helper(tmp.getList(), res);
//                }
//            }
//        }
//
//        @Override
//        public Integer next() {
//            return res.get(count++);
//        }
//
//        @Override
//        public boolean hasNext() {
//            if (count >= res.size()) {
//                return false;
//            }
//            return true;
//        }
//    }
}
