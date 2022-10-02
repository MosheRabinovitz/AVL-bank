import java.util.*;
class Bank{
    private AVLTree bank = new AVLTree();
    Scanner scanner = new Scanner(System.in);
    int x, y, z, i;
    String name;
    boolean flag1 = true;
    boolean flag2 = true;
    
    public void play(){
        do{
            System.out.println("Welcome to the bank!");
            System.out.println();
            System.out.println("Please input your choice:");
            System.out.println();
            System.out.println("1  join us.");
            System.out.println("2  check your balance.");
            System.out.println("3  deposit.");
            System.out.println("4  withdraw.");
            System.out.println("5  delete your account.");
            System.out.println("6  sign in / change account.");
            
            x = scanner.nextInt();
            System.out.println();
            if(x == 1){
                System.out.println("Welcome!");
                System.out.println("Please enter your name:");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println();
                System.out.println("Hi " + name + " please enter your ID:");
                y = scanner.nextInt();
                insert(y, name);
                System.out.println("Done, welcome to our bank :)");
            }
            else{
                if(flag2 || x == 6){
                    System.out.println("Please enter your ID:");
                    i = 0;
                    do{
                        i ++;
                        y = scanner.nextInt();
                        if(this.bank.search(y) == null )
                            System.out.println("Account not found, please try again");
                        }while(this.bank.search(y) == null && i < 5);
                    if(this.bank.search(y) == null){
                        System.out.println("Field:");
                        return;
                    }
                }
            }
            if(x == 2){
                System.out.println(getName(y) + " your balance is: " + getBalance(y));
            }
            if(x == 3){
                System.out.println("Please enter amount:");
                z = scanner.nextInt();
                setBalance(y,z);
                System.out.println(getName(y) + " your balance now is: " + getBalance(y));
            }
            if(x == 4){
                System.out.println("please enter amount:");
                z = scanner.nextInt();
                setBalance(y, -z);
                System.out.println(getName(y) + " your balanse now is: " + getBalance(y));
            }
            if(x == 5){
                remove(y);
                System.out.println("Done, Good bye :(");
                return;
            }
            flag2 = false;
            
            System.out.println();
            System.out.println("Would you like to do somthing else?");
            System.out.println("Press 1 for Yes, or 2 for No.");
            System.out.println();
            x = scanner.nextInt();
            if(x == 2){
                flag1 = false;
                System.out.println("Thank you for using our bank servises");
                return;
                }
        }while(flag1);
    }
    private void insert(int ID, String name){
        this.bank.addNode(ID, name);
    }
    private void remove(int ID){
        this.bank.removeNode(ID);
    }
    private double getBalance(int ID) {
        return this.bank.search(ID).getBalance();
    }
    private String getName(int ID) {
        return this.bank.search(ID).getName();
    }
    private void setBalance(int ID, double num) {
        this.bank.search(ID).setBalance(num);
    }
}