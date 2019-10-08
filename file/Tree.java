package com.vinhhua;

public class Tree {
    private TreeNode root;

    /**
     * insert the new value from the ROOT node.
     * @param value that we want to insert into the tree.
     */
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    /**
     * Traverse the tree from
     */

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    /**
     * traverse the tree inorder so it will be sorted. Again, starts from root.
     */
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInorder();
        }
    }

    /**
     * Get the value in the tree if it exists.
     * @param value that we want to retrieve.
     * @return the value of the node, null if the node contains the value does not exist.
     */
    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    /**
     * Private method that allows the main delete method to call it recursively.
     * @param subtreeRoot we want to search the entire tree because we don't know which direction to search initially.
     * @param value the value that we want to delete.
     * @return
     */
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            // this is when it equals to the subtreeRoot
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children
            // Replace the value in the subtreeRoot node with the smallest value from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;

    }

    /**
     * Get the minimum value from the tree.
     * @return if tree is null then return the lowest possible int, otherwise return the minimum value.
     */
    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.min();
    }

    /**
     * Get the maximum value from the tree.
     * @return if tree is null then return Integer.MAX_VALUE, otherwise return the maximum value from the tree.
     */

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.max();
    }
}
