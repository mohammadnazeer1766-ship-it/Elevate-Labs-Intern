public class Main {
    public static void main(String[] args) {
        Account acc = new Account("A101", 5000);

        acc.deposit(2500);
        acc.withdraw(4000);
        acc.withdraw(8000); // will show insufficient balance

        System.out.println("Final Balance: " + acc.getBalance());

        System.out.println("\nTransaction History:");
        for (String t : acc.getTransactionHistory()) {
            System.out.println(t);
        }
    }
}

