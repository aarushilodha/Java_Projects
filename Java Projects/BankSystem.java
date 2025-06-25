import java.util.Scanner;
class BankAccount{
    String name;
    double balance;

    public BankAccount(String name, double balance) {
        this.name=name;
        this.balance=balance;
}
void deposit(double amount){
    balance += amount;
    System.out.println("Deposited: "+amount);
}
void withdraw(double amount){
    if(amount>balance){
        System.out.println("Insufficient balance!");
    }
    else{
        balance -= amount;
        System.out.println("Withdrew:" +amount);
    }
}
void displayBalance(){
        System.out.println("Current Balance: "+balance);
    }
}
public class BankSystem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Aarushi", 50000.0);
        
        int choice;
        do{
            System.out.println("\1 Deposit\2 Withdraw\3 Balance\4 Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                System.out.print("Amount to deposit:");
                account.deposit(sc.nextDouble());
                break;

                case 2: 
                System.out.print("Amount to withdraw:");
                account.withdraw(sc.nextDouble());
                break;

                case 3:
                account.displayBalance();
                break;

                case 4:
                System.out.println("Thank you for using our service!");
                break;

                default: 
                System.out.println("Invalid Option.");
            } 
        }
        while(choice!=4);
     }
}

