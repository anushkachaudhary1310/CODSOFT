import java.util.Scanner;

public class Task3 {
    static double BankBalance;
    public static void Withdraw(double amount){
        if(amount<=BankBalance){
            System.out.println(amount+ " rupees are debited from your bank account.");
            BankBalance=BankBalance-amount;
        }
        else if(amount>BankBalance){
            System.out.println("Your current Bank Balance is not enough for the widthdraw.");
        }
        else{
            System.out.println("Invalid choice.Transaction Failed.");
        }
        checkBalance();
    }
    public static void Depositing(double amount){
        BankBalance=BankBalance+amount;
        System.out.println("The following "+amount+" has been credited in your bank account.");
        checkBalance();
    }
    public static void checkBalance(){
        System.out.println("Your current balance in your bank account is: "+BankBalance);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Bank Balance for the account: ");
            BankBalance=sc.nextDouble();
            while(true){
                System.out.println("Enter \'W' for Withdrawing from your bank account");
                System.out.println("Enter \'D' for Depositing into your bank account");
                System.out.println("Enter \'B' for Checking the Balance in your bank account");
                System.out.println("Enter \'E' for exiting the transactions.");
                System.out.println("Enter your choice: ");
                char choice=sc.next().charAt(0);
            
            switch (choice) {
                case 'W':
                    System.out.println("enter the amount you want to widthdraw: ");
                    double amount=sc.nextDouble();
                    Withdraw(amount);
                    break;
                case 'D':
                    System.out.println("enter the amount you want to deposit: ");
                    double amt=sc.nextDouble();
                    Depositing(amt);
                    break;
                case 'B':
                    checkBalance();
                    break;
                case 'E':
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;

                }

            }
        }
        
    }
}
