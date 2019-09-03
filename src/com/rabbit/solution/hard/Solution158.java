package com.rabbit.solution.hard;

public class Solution158 {
//    private int readPos = 0;
//    private int readCnt = 0;
//    private char[] localBuf = new char[4];
//
//    public int read(char[] buf, int n) {
//        int pos = 0;
//        while (pos < n) {
//            if (readPos == 0) {
//                readCnt = read4(localBuf);
//            }
//            if (readCnt == 0) {
//                break;
//            }
//            while (pos < n && readPos < readCnt) {
//                buf[pos] = localBuf[readPos];
//                pos++;
//                readPos++;
//            }
//            if (readPos == readCnt) {
//                readPos = 0;
//            }
//        }
//
//        return pos;
//    }
}
