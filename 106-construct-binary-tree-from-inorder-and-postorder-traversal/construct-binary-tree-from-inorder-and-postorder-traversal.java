class Solution {
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = postorder[index--];
        TreeNode root = new TreeNode(value);

        int pos = left;

        while (inorder[pos] != value) {
            pos++;
        }

        root.right = build(inorder, postorder, pos + 1, right);
        root.left = build(inorder, postorder, left, pos - 1);

        return root;
    }
}