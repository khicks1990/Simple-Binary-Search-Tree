public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Adding values to the binary search tree
        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);

      // Displaying the contents of the tree
      bst.printTree();

        // Searching for values in the binary search tree
        System.out.println(bst.contains(40)); // Output: true
        System.out.println(bst.contains(90)); // Output: false

        // Removing a value from the binary search tree
        bst.remove(30);

      // Displaying the contents of the tree
      bst.printTree();
      
        System.out.println(bst.contains(30)); // Output: false


    }
}