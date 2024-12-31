public class BinarySearchTree {

    private Node root; // The root node of the binary search tree

    private class Node {
        private int value; // The value stored in the node
        private Node left; // The left child of the node
        private Node right; // The right child of the node

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void add(int value) {
        root = addRecursive(root, value); // Call the private recursive add method with the root node
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value); // Create a new node with the value if the current node is null
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value); // Add the value to the left subtree if it's less than the current node's value
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value); // Add the value to the right subtree if it's greater than the current node's value
        }

        return current;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value); // Call the private recursive contains method with the root node
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false; // Return false if the current node is null (value not found)
        }

        if (value == current.value) {
            return true; // Return true if the value is equal to the current node's value
        }

        if (value < current.value) {
            return containsRecursive(current.left, value); // Search in the left subtree if the value is less than the current node's value
        } else {
            return containsRecursive(current.right, value); // Search in the right subtree if the value is greater than the current node's value
        }
    }

    public void remove(int value) {
        root = removeRecursive(root, value); // Call the private recursive remove method with the root node
    }

    private Node removeRecursive(Node current, int value) {
        if (current == null) {
            return null; // Return null if the current node is null (value not found)
        }

        if (value == current.value) {
            // Case 1: Node to be removed has no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Node to be removed has one child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: Node to be removed has two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = removeRecursive(current.left, value); // Remove the value from the left subtree if it's less than the current node's value
            return current;
        }

        current.right = removeRecursive(current.right, value); // Remove the value from the right subtree if it's greater than the current node's value
        return current;
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left); // Recursively find the smallest value in the given subtree
    }

    public void printTree() {
        inOrderTraversal(root);
          System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
            
        }
    }
}