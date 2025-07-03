import java.util.Scanner;

public class ATMSimulator {
    private static final int PIN = 1234;
    private static double balance = 10000.0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM!");

        System.out.print("Enter your PIN: ");
        int enteredPIN = sc.nextInt();

        if(enteredPIN != PIN){
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }
        int choice;
        do{
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance\n");
            System.out.println("2. Deposit\n");
            System.out.println("3. Withdraw\n");
            System.out.println("4. Exit\n");
            System.out.println("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(sc);
                    break;
                
                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    public static void checkBalance(){
        System.out.printf("Your current balance is: %.2f\n",balance);
    }

    public static void deposit(Scanner sc){
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if(amount>0){
            balance += amount;
            System.out.printf("%.2f deposited successfully. \n", amount);
        }
        else{
            System.out.println("invalid deposit amount.");
        }
    }

    public static void withdraw(Scanner sc){
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if(amount>balance){
            System.out.println("Insufficient balance.");
        }
        else if(amount<= 0){
            System.out.println("Invalid withdrawal amount.");
        }
        else{
            balance -= amount;
            System.out.printf("%.2f withdrawn successfully.\n",amount);
        }
    }
}
