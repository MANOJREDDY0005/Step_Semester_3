import java.util.Scanner;

class Customer {
    public double calculateAmount(double amount) {
        return amount;
    }
}

class Student extends Customer {

    @Override
    public double calculateAmount(double amount) {
        return amount - (amount * 0.10);
    }
}

class Staff extends Customer {

    @Override
    public double calculateAmount(double amount) {
        return amount - (amount * 0.05);
    }
}

class Guest extends Customer {

    @Override
    public double calculateAmount(double amount) {
        return amount + 10;
    }
}

public class CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student();
                    break;

                case "STAFF":
                    customer = new Staff();
                    break;

                default:
                    customer = new Guest();
                    break;
            }

            double finalAmount = customer.calculateAmount(amount);

            total += finalAmount;

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    finalAmount
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}