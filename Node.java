public class Node
{
    //propertires
    private key key;
    private int height;
    private Node leftSon, rightSon;
    
    // constructor
    public Node(int ID, String name) {
        this.key = new key(ID, name);
        this.height = 1;
        this.leftSon = null;
        this.rightSon = null;
    }
    
    // the get methods
    public Node getLeftSon() {
        return this.leftSon;
    }
    public Node getRightSon() {
        return this.rightSon;
    }
    public int getID(){
        return this.key.getID();
    }
    public int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
    }
    public double getBalance() {
        return this.key.getBalance();
    }
    public String getName(){
        return this.key.getName();
    }
    
    // the set methods
    public void setLeftSon(Node node) {
        leftSon = node;
    }
    public void setRightSon(Node node) {
        this.rightSon = node;
    }
    public void setBalance(double num) {
        this.key.setBalance(num);
    }
    public void setHeight() {
        this.height = 1 + Math.max(this.getHeight(this.getLeftSon()),this.getHeight(this.getRightSon()));
    }
} //end of class Node
    

    
