
class BinarySearchTree {

    /*
     * Class containing left and right child of current node and key value
     */
    class Node {
        String key;
        String[] value;
        Node left, right;

        public Node(String item, String[] arr) {
            key = item;
            value = arr;
            left = right = null;
        }
    }

    // Root of BST
    private Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(String key, String[] value) {
        root = insertRec(root, key, value);
    }

    /*
     * A recursive function to insert a new key in BST
     */
    public Node insertRec(Node root, String key, String[] value) {

        /*
         * If the tree is empty, return a new node
         */
        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        /* Otherwise, recur down the tree */

        if (key.compareToIgnoreCase(root.key) < 0)
            root.left = insertRec(root.left, key, value);
        else if (key.compareToIgnoreCase(root.key) >= 0)
            root.right = insertRec(root.right, key, value);

        /* return the (unchanged) node pointer */
        return root;
    }

    // Muestra todas las entradas del arbol con sus valores
    public void getBST() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {

            inorderRec(root.left);

            try {
                System.out.println("\n - " + root.key);

                System.out.println("   Ingles: " + root.value[0]);
                System.out.println("   Espanol: " + root.value[1]);
                System.out.println("   Frances: " + root.value[2]);

            } catch (Exception e) {
                System.out.println("\n - " + root.key + " - sin datos");
            }

            inorderRec(root.right);
        }
    }

    // Busca a un nodo por su clave y regresa su valor
    String[] arr = null;
    public String[] getNode(String key) {
       arr = null;
       getNodeRec(root, key);
       return arr;
    }

    public void getNodeRec(Node root, String key) {
        if (root != null) {

            getNodeRec(root.left, key);

            if (root.key.equals(key)) {
                arr =  root.value;
            }

            getNodeRec(root.right, key);
        }
    }
}
