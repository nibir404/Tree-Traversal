import java.util.LinkedList;

public class TreeTraversal {
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        System.out.println("Pre order Traversal : ");
        tree.printPreOrder();
        System.out.println();

        System.out.println("In order traversal : ");
        tree.printOrder();
        System.out.println();

        System.out.println("Post order traversal : ");
        tree.printPostOrder();
        System.out.println();

        System.out.println("Level order traversal : ");
        tree.printLevelOrder();
        System.out.println();
    }
}

    class Node{
        Node left,right;
        int data;

        public Node(int data){
            this.data =data;
        }

        public void insert(int value){
            if (value<data)
                if (left == null){
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            else {
                if (right == null){
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public void printOrder(){
            if (left != null){
                left.printOrder();
            }
            System.out.print(data +" ");
            if (right != null){
                right.printOrder();
            }
        }

        public void printPreOrder(){
            System.out.print(data+" ");
            if (left != null){
                left.printPreOrder();
            }
            if (right != null){
                right.printPreOrder();
            }
        }

        public void printPostOrder(){
            if (left != null){
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.print(data+" ");
        }

    public void printLevelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0){
            Node head = queue.remove();
            System.out.print(head.data+" ");

            if (head.left != null){
                queue.add(head.left);
            }
            if (head.right != null){
                queue.add(head.right);
            }
        }
    }
}
