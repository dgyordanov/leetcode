package edu.leetcode.diyan;

import java.util.Arrays;

public class ZigZag {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int numCol =  (s.length() / (numRows + numRows - 2) * (numRows - 1)) + (numRows - 1);
        char[][] resultArray = new char[numRows][numCol];
        for (char[] row : resultArray) {
            Arrays.fill(row, ' ');
        }

        for (int charAt = 0; charAt < s.length(); charAt = charAt + numRows + numRows - 2) {
            int startCol = (charAt / (numRows + numRows - 2)) * (numRows - 1);
            String nextZigZagChars = s.substring(charAt, Math.min(charAt + numRows + numRows - 2, s.length()));
            addZigZag(resultArray, startCol, nextZigZagChars);
        }


        return toResultString(resultArray);
    }

    private String toResultString(char[][] resultArray) {
        StringBuilder result = new StringBuilder();
        for (char[] chars : resultArray) {
            for (char aChar : chars) {
                if (aChar != ' ') {
                    result.append(aChar);
                }
            }
        }
        return result.toString();
    }

    private void addZigZag(char[][] resultArray, int startCol, String nextZigZagChars) {
        int numRows = resultArray.length;
        for (int i = 0; i < nextZigZagChars.length(); i++) {
            if (i < numRows) {
                resultArray[i][startCol] = nextZigZagChars.charAt(i);
            } else {
                resultArray[numRows + numRows - 1 - (i + 1)][startCol + (i + 1) - numRows] = nextZigZagChars.charAt(i);
            }
        }

    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
//        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
        System.out.println(zigZag.convert("a", 1));
    }
}
