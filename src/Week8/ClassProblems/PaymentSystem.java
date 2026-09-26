import java.util.Scanner;

class Payment {
    public double calculateAmount(double amount) {
        return amount;
    }
}

class CardPayment extends Payment {
    @Override
    public double calculateAmount(double amount) {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {
    @Override
    public double calculateAmount(double amount) {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {
    @Override
    public double calculateAmount(double amount) {
        return amount;
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment();
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment();
            } else {
                payment = new BankTransferPayment();
            }

            double adjustedAmount = payment.calculateAmount(amount);

            total += adjustedAmount;

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}