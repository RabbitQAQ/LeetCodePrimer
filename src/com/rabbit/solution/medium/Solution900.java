package com.rabbit.solution.medium;

public class Solution900 {
    class RLEIterator {

        int currNum;
        int currCount;
        int index;
        boolean isEnd;
        int[] A;

        public RLEIterator(int[] A) {
            if (A.length == 0) {
                isEnd = true;
                return;
            }
            index = 0;
            currNum = A[index + 1];
            currCount = A[index];
            isEnd = false;
            this.A = A;
        }

        public int next(int n) {
            if (isEnd) {
                return -1;
            }
            while (n >= currCount) {
                n -= currCount;
                index += 2;
                if (n > 0 && index >= A.length) {
                    isEnd = true;
                    return -1;
                } else if (n == 0) {
                    isEnd = index >= A.length;
                    int res = currNum;
                    if (!isEnd) {
                        currCount = A[index];
                        currNum = A[index + 1];
                    }
                    return res;
                }
                currCount = A[index];
                currNum = A[index + 1];
            }

            currCount -= n;
            return currNum;
        }
    }
}
