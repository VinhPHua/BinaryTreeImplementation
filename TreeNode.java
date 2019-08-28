package com.vinhhua;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    /**
     * This method insert a new value into a binary tree.
     * It does not accept duplicate value.
     * @param value that we want to insert into the tree.
     */
    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    /**
     * This method will return the value that we want to retrieve.
     * @param value that we want to retrieve
     * @return the node of the value
     */

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    /**
     * This method will traverse all the way through to the end of leftChild since it always contains the smaller value
     * on the left side of the tree. So the most LeftChild node will be the node that contains the minimum value.
     */
    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    /**
     * This method will return the maximum value by traversing through the right side of the tree.
     * @return the maximum value.
     */
    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    /**
     * This method traverses the tree in-order, means that the result will be sorted.
     */
    public void traverseInorder() {
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInorder();
        }
    }

    public void traversePreOrder() {
        System.out.print(data+ ", ");
        if (leftChild != null) {
            leftChild.traversePreOrder();
        }

        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (leftChild != null) {
            leftChild.traversePreOrder();
        }

        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
        System.out.println(data +", ");
    }

    /**
     * Getter method.
     * @return the data that we call from the reference.
     */
    public int getData() {
        return data;
    }

    /**
     * Setter method to set data.
     * @param data that we want to set for the tree.
     */
    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Data = " +data;
    }
}
