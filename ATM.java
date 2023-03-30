
import java.util.*;

class bankaccount // Class created
{
    static void register() // Method created for register bank acc
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATM.name = s1.nextLine();
        System.out.println("Enter username :");
        String user = s1.nextLine();
        System.out.println("Enter password :");
        String pass = s1.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accnumber = s1.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.opt(); // Method opt called
        while (true) {
            display(ATM.name);
            int choice = s1.nextInt();
            if (choice == 1) {
                login(user, pass);
                break;
            } else {
                if (choice == 2) {
                    System.exit(0);
                } else {
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }

    static void display(String name) {
    }

    static void login(String user, String pass) {
    }
}

class transaction // Transaction class created
{
    static void withdraw() // Method to withdraw money
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter amount to withdraw :");
        int wcash = s1.nextInt();
        if (wcash <= ATM.balance) {
            ATM.balance = ATM.balance - wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs" + wcash + "/-withdraw successfully");
        } else {
            System.out.println("insufficient balance to withdraw the cash");
        }
        ATM.opt(); // Method opt called
    }

    static void deposit() // Method to deposit money
    {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter amount to deposit :");
        int dcash = s1.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs." + dcash + "/- deposit successful!");
        ATM.opt(); // Method opt called
    }

    static void transfer() // Method to transfer money
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the receiving body:");
        String s = s1.nextLine();
        System.out.println("Enter the account number of the receiving body");
        int num = s1.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash = s1.nextInt();
        if (tcash <= ATM.balance) {
            ATM.balance = ATM.balance - tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs." + tcash + "/- transferred successfully");
        } else {
            System.out.println("insufficient balance to transfer the cash");
        }
    }
}

class check {
    static void checkbalance() // Method to check balance int the acc
    {
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        ATM.opt(); // Method opt called
    }
}

class his // class created for transaction history
{
    static void transactionhistory() // Method to get transaction history
    {
        System.out.println("Transaction History :");
        int k = 0;
        if (ATM.balance > 0) {
            for (int i = 0; i < (ATM.history.size() / 2); i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(ATM.history.get(k) + " ");
                    k++;
                }
            }
        } else {
            System.out.println("your account is empty");
        }
        ATM.opt(); // Method opt called
    }
}

public class ATM // Class ATM created
{
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<String>(); // Array list

    static void updatebalance(int dcash) {
        balance = balance + dcash;
    }

    static void showbalance() {
        System.out.println(balance);
    }

    public static void homepage() {
        System.out.println("\033[H\033[2J");
        Scanner s1 = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        System.out.println("---------------------------");
        int choice = s1.nextInt();
        if (choice == 1) {
            bankaccount.register();
        } else {
            if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }

    static void opt() // Method opt created
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("WELCOME " + ATM.name + "! TO ATM SYSTEM");
        System.out.println("Select option : ");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. WITHDRAW");
        System.out.println("3. DEPOSIT");
        System.out.println("4. TRANSFER");
        System.out.println("5. TRANSACTION HISTORY");
        System.out.println("6. EXIT");
        System.out.println("---------------------------");
        System.out.print("Enter your choice : ");
        int choice = s1.nextInt();
        switch (choice) {
            case 1:
                check.checkbalance();
            case 2:
                transaction.withdraw();
            case 3:
                transaction.deposit();
            case 4:
                transaction.transfer();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) // Main method
    {
        homepage();
    }
}