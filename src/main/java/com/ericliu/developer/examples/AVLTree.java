package com.ericliu.developer.examples;

import java.util.Map;

/**
 * Created by ericliu on 6/06/2016.
 */
public class AVLTree<K, V> {

    Node<K, V> root;

    static class Node<K, V> implements Map.Entry<K, V> {
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        final K key;
        V value;
        int height;

        Node(Node<K, V> parent, K key) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
        }

        Node<K, V> copy(Node<K, V> parent) {
            Node<K, V> result = new Node<K, V>(parent, key);
            if (left != null) {
                result.left = left.copy(result);
            }
            if (right != null) {
                result.right = right.copy(result);
            }
            result.value = value;
            result.height = height;
            return result;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override public boolean equals(Object o) {
            if (o instanceof Map.Entry) {
                Map.Entry other = (Map.Entry) o;
                return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()));
            }
            return false;
        }

        @Override public int hashCode() {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }

        @Override public String toString() {
            return key + "=" + value;
        }

        /**
         * Returns the next node in an inorder traversal, or null if this is the
         * last node in the tree.
         */
        Node<K, V> next() {
            if (right != null) {
                return right.first();
            }

            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while (parent != null) {
                if (parent.left == node) {
                    return parent;
                }
                node = parent;
                parent = node.parent;
            }
            return null;
        }

        /**
         * Returns the previous node in an inorder traversal, or null if this is
         * the first node in the tree.
         */
        public Node<K, V> prev() {
            if (left != null) {
                return left.last();
            }

            Node<K, V> node = this;
            Node<K, V> parent = node.parent;
            while (parent != null) {
                if (parent.right == node) {
                    return parent;
                }
                node = parent;
                parent = node.parent;
            }
            return null;
        }

        /**
         * Returns the first node in this subtree.
         */
        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            while (child != null) {
                node = child;
                child = node.left;
            }
            return node;
        }

        /**
         * Returns the last node in this subtree.
         */
        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            while (child != null) {
                node = child;
                child = node.right;
            }
            return node;
        }
    }


    private void replaceInParent(Node<K, V> node, Node<K, V> replacement) {
        final Node<K, V> parent = node.parent;
        node.parent = null;
        if (replacement != null) {
            replacement.parent = parent;
        }

        if (parent != null) {
            if (parent.left == node) {
                parent.left = replacement;
            } else {
                // assert (parent.right == node);
                parent.right = replacement;
            }
        } else {
            root = replacement;
        }
    }

    /**
     * Rebalances the tree by making any AVL rotations necessary between the
     * newly-unbalanced node and the tree's root.
     *
     *
     * @param unbalanced the parent of the newly-inserted Node.
     *
     * @param insert true if the node was unbalanced by an insert; false if it
     *     was by a removal.
     */
    public void rebalance(Node<K, V> unbalanced, boolean insert) {
        for (Node<K, V> node = unbalanced; node != null; node = node.parent) { // moving up the path
            final Node<K, V> left = node.left;
            final Node<K, V> right = node.right;
            final int leftHeight = left != null ? left.height : 0;
            final int rightHeight = right != null ? right.height : 0;

            final int delta = leftHeight - rightHeight;
            if (delta == -2) { // right heavy

                final Node<K, V> rightLeft = right.left;
                final Node<K, V> rightRight = right.right;
                final int rightRightHeight = rightRight != null ? rightRight.height : 0;
                final int rightLeftHeight = rightLeft != null ? rightLeft.height : 0;

                final int rightDelta = rightLeftHeight - rightRightHeight;
                if (rightDelta == -1 || (rightDelta == 0 && !insert)) {
                    rotateLeft(node); // AVL right right
                } else {
                    // assert (rightDelta == 1);
                    rotateRight(right); // AVL right left
                    rotateLeft(node);
                }
                if (insert) {
                    break; // no further rotations will be necessary
                }

            } else if (delta == 2) { // left heavy

                final Node<K, V> leftLeft = left.left;
                final Node<K, V> leftRight = left.right;
                final int leftRightHeight = leftRight != null ? leftRight.height : 0;
                final int leftLeftHeight = leftLeft != null ? leftLeft.height : 0;

                final int leftDelta = leftLeftHeight - leftRightHeight;
                if (leftDelta == 1 || (leftDelta == 0 && !insert)) {
                    rotateRight(node); // AVL left left
                } else {
                    // assert (leftDelta == -1);
                    rotateLeft(left); // AVL left right
                    rotateRight(node);
                }
                if (insert) {
                    break; // no further rotations will be necessary
                }

            } else if (delta == 0) {
                node.height = leftHeight + 1; // leftHeight == rightHeight
                if (insert) {
                    break; // the insert caused balance, so rebalancing is done!
                }

            } else {
                // assert (delta == -1 || delta == 1);
                node.height = Math.max(leftHeight, rightHeight) + 1; // update the height
                if (!insert) {
                    break; // the height hasn't changed, so rebalancing is done!
                }
            }
        }
    }

    /**
     * Rotates the subtree so that its root's right child is the new root.
     */
    private void rotateLeft(Node<K, V> root) {
        final Node<K, V> left = root.left;
        final Node<K, V> pivot = root.right;
        final Node<K, V> pivotLeft = pivot.left;
        final Node<K, V> pivotRight = pivot.right;

        // move the pivot's left child to the root's right
        root.right = pivotLeft;
        if (pivotLeft != null) {
            pivotLeft.parent = root;
        }

        replaceInParent(root, pivot);

        // move the root to the pivot's left
        pivot.left = root;
        root.parent = pivot;

        // fix heights
        root.height = Math.max(left != null ? left.height : 0,
                pivotLeft != null ? pivotLeft.height : 0) + 1;
        pivot.height = Math.max(root.height,
                pivotRight != null ? pivotRight.height : 0) + 1;
    }

    /**
     * Rotates the subtree so that its root's left child is the new root.
     */
    private void rotateRight(Node<K, V> root) {
        Node<K, V> pivot = root.left;
        Node<K, V> right = root.right;
        Node<K, V> pivotLeft = pivot.left;
        Node<K, V> pivotRight = pivot.right;

        // move the pivot's right child to the root's left
        root.left = pivotRight;
        if (pivotRight != null) {
            pivotRight.parent = root;
        }

        replaceInParent(root, pivot);

        // move the root to the pivot's right
        pivot.right = root;
        root.parent = pivot;

        // fixup heights
        root.height = Math.max(right != null ? right.height : 0,
                pivotRight != null ? pivotRight.height : 0) + 1;
        pivot.height = Math.max(root.height,
                pivotLeft != null ? pivotLeft.height : 0) + 1;
    }
}
