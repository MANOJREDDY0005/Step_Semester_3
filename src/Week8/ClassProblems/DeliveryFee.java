import java.util.Scanner;

class Delivery {

    public double calculateFee(double weight, double distance, double customs) {
        return 0;
    }
}

class Standard extends Delivery {

    @Override
    public double calculateFee(double weight, double distance, double customs) {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class Express extends Delivery {

    @Override
    public double calculateFee(double weight, double distance, double customs) {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class International extends Delivery {

    @Override
    public double calculateFee(double weight, double distance, double customs) {
        return 25 + (2.00 * weight) + (0.50 * distance) + customs;
    }
}

public class DeliveryFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double customs = 0;

            Delivery delivery;

            if (type.equals("STANDARD")) {

                delivery = new Standard();

            } else if (type.equals("EXPRESS")) {

                delivery = new Express();

            } else {

                customs = sc.nextDouble();

                delivery = new International();
            }

            double fee =
                    delivery.calculateFee(weight, distance, customs);

            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}