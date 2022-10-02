import java.util.*;
class AVLTree {
    
    //propertires
    private Node root;
    
    // constructor
    public AVLTree(){
        root = null; 
    }
    
    // the public methods
    public void addNode(int ID, String name){
         this.root = addNode(this.root, ID, name);      
    }
    public void removeNode(int ID){
        this.root = removeNode(this.root, ID);
    }
    public Node search(int ID){
        return search(this.root, ID);
    }
    public void inorder(){
        inorder(this.root);
    }
    public void preorder(){
        preorder(this.root);
    }
    public void postorder(){
        postorder(this.root);
    }
    public void levelOrder(){
        levelOrder(this.root);
    }
    
    // the private methods
    private boolean isBalance(Node node){
        return(Math.abs(node.getHeight(node.getLeftSon()) - node.getHeight(node.getRightSon())) <= 1);        
    }
    private Node addNode(Node node, int ID, String name){
        if(node == null)
            return new Node(ID, name);
        if(ID >= node.getID())
            node.setRightSon(addNode(node.getRightSon(), ID, name));
        else
            node.setLeftSon(addNode(node.getLeftSon(), ID, name));
        node.setHeight();
        return balanceAVL(node);
    }
    private Node removeNode(Node node, int ID){
        if(node == null)
            return null;
        if(ID > node.getID())
            node.setRightSon(removeNode(node.getRightSon(), ID));
        else
            if(ID < node.getID())
                node.setLeftSon(removeNode(node.getLeftSon(), ID));
            else{
                if(node.getRightSon() == null && node.getLeftSon() == null)
                    return null;
                if(node.getRightSon() == null)
                    return node.getLeftSon();
                if(node.getLeftSon() == null)
                    return node.getRightSon();
                else{
                    Node temp = findSuccessor(node.getRightSon());
                    node.setRightSon(removeNode(node.getRightSon(), temp.getID()));
                    temp.setLeftSon(node.getLeftSon());
                    temp.setRightSon(node.getRightSon());
                    node = temp;
                }
            }
        node.setHeight();
        return balanceAVL(node);
     }
    private Node balanceAVL(Node node){
        if(isBalance(node))
            return node;
        if((node.getHeight(node.getRightSon()) > node.getHeight(node.getLeftSon())))
            if(node.getHeight(node.getRightSon().getRightSon()) > node.getHeight(node.getRightSon().getLeftSon()))
                return rotationLeft(node);
            else{
                node.setRightSon(rotationRight(node.getRightSon()));
                return rotationLeft(node);
                }
        else
            if(node.getHeight(node.getLeftSon().getLeftSon()) > node.getHeight(node.getLeftSon().getRightSon()))
                return rotationRight(node);
            else{
                node.setLeftSon(rotationLeft(node.getLeftSon()));
                return rotationRight(node);
                }
    }
     private Node findSuccessor(Node node){
        Node successor = node;
        while(successor.getLeftSon() != null)
            successor = successor.getLeftSon();
        return successor;
    }
    private Node rotationLeft(Node node){
        Node res = node.getRightSon();
        Node temp = res.getLeftSon();
        res.setLeftSon(node);
        node.setRightSon(temp);
        node.setHeight();
        res.setHeight();
        return res;
    }
    private Node rotationRight(Node node){
        Node res = node.getLeftSon();
        Node temp = res.getRightSon();
        res.setRightSon(node);
        node.setLeftSon(temp);
        node.setHeight();
        res.setHeight();
        return res;
    }
    private Node search(Node node, int ID){
        Node temp = node;
        while(temp != null && ID != temp.getID()) 
           temp = (ID > node.getID())? temp.getRightSon() : temp.getLeftSon();
        return temp;    
    }
    private static void levelOrder(Node root){
        Queue <Node> queue = new LinkedList<Node>();
        queue.add(root); 
        while(!queue.isEmpty()){
            Node p = queue.remove();
            System.out.print(p.getID() + ",");
            if(p.getLeftSon() != null)
                queue.add(p.getLeftSon());
            if(p.getRightSon() != null)
                queue.add(p.getRightSon());
        }
    }
    private static void postorder(Node root){
        if(root == null)
            return;
        postorder(root.getLeftSon());
        postorder(root.getRightSon());
        System.out.print(root.getID() + ",");
     }
    private static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.getID() + ",");
        preorder(root.getLeftSon());
        preorder(root.getRightSon());
    }
    private static void inorder(Node root){
        if(root == null)
            return;
        inorder(root.getLeftSon());
        System.out.print(root.getID() + ",");
        inorder(root.getRightSon());
    }
}