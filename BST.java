import java.util.LinkedList;

/**
 * Created by Bartłomiej on 11.05.2016.
 */
public class BST {
    Node root;

    public BST(){
        root=null;
    }


    public void insert(String id, int line){
        Node newNode = new Node(id,line);
        if(root==null){
            root = newNode;
            //System.out.println(root.word+root.list.get(0)+"\n");
            return;
        }
        Node current = root;


            Node parent = null;
            while (true) {
                parent = current;
                if (id.equals(current.word)) {
                    current.list.add(line);
                    return;
                }
                if (id.compareTo(current.word) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }

    }


    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.println(root.word);
            display(root.right);
        }
    }

    public void display2(Node node)
    {
        if(node!=null)
        {
            display2(node.left);

            System.out.printf("%-12s ",node.word);
            for(Integer x : node.list)
                System.out.print(x + ",");
            System.out.println();


            display2(node.right);
        }
    }

    public void bfs(Node node)
    {
        LinkedList<Node> l = new LinkedList<>();
        l.add(node);
        while(!l.isEmpty())
        {
            if(l.getFirst().left!=null)
                l.add(l.getFirst().left);

            if(l.getFirst().right!=null)
                l.add(l.getFirst().right);

            System.out.print(l.getFirst().word+" ");
            l.removeFirst();
        }
    }

    public boolean delete(String id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(!current.word.equals(id)){
            parent = current;
            if(current.word.compareTo(id)>0){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }

        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

}
