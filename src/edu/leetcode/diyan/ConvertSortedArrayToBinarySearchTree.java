package edu.leetcode.diyan;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();
        TreeNode result = solution.sortedArrayToBST(new int[]{-10, -3});
        System.out.println(result);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        validate(nums);

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        if (nums.length == 2) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        }

        int treeRoot = (nums.length - 1) / 2;
        return new TreeNode(
                nums[treeRoot],
                sortedSubarrayToBST(nums, 0, treeRoot - 1),
                sortedSubarrayToBST(nums, treeRoot + 1, nums.length - 1)
        );
    }

    private TreeNode sortedSubarrayToBST(int[] nums, int from, int to) {
        if (from == to) {
            return new TreeNode(nums[from]);
        }
        if (to - from == 1) {
            return new TreeNode(nums[to],
                    new TreeNode(nums[from]),
                    null
            );
        }
        int treeRoot = getRootIndex(from, to);
        return new TreeNode(nums[treeRoot],
                sortedSubarrayToBST(nums, from, treeRoot - 1),
                sortedSubarrayToBST(nums, treeRoot + 1, to)
        );
    }

    private void validate(int[] nums) {
        if (nums.length < 1 || nums.length > Math.pow(10, 4)) {
            throw new IllegalArgumentException("Array size not correct");
        }

        if (nums[0] < - Math.pow(10, 4) || nums[nums.length - 1] >  Math.pow(10, 4)){
            throw new IllegalArgumentException("Invalid numbers in array");
        }
    }

    private int getRootIndex(int from, int to) {
        return from + ((to - from) / 2);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
