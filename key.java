public class key {
    //properties
    private String name;
    private int ID;
    private double balance;
    
    //constructor    
    public key(int id, String name) {
        this.name = name;
        this.ID = id;
        this.balance = 0;
    }
    
    //methods
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double x) {
        this.balance += x;
    }
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}