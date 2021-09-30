package edu.leetcode.diyan;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int currentHighestStart = 0;
        for (int start = 0; start < height.length; start++) {
            if (currentHighestStart > height[start]) {
                continue;
            } else {
                currentHighestStart = height[start];
            }

            int currentHighestEnd = 0;
            for (int end = height.length - 1; end > start; end--) {
                if (currentHighestEnd > height[end]) {
                    continue;
                } else {
                    currentHighestEnd = height[end];
                }
                result = Math.max(result, calcArea(height, start, end));
            }
        }
        return result;
    }

    private int calcArea(int[] height, int start, int end) {
        return Math.min(height[start], height[end]) * (end - start);
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 1}));
    }
}
