import java.util.Scanner;

class Vehicle {

    public double calculateCharge(int hours) {
        return 0;
    }
}

class Bike extends Vehicle {

    @Override
    public double calculateCharge(int hours) {
        return 10 * hours;
    }
}

class Car extends Vehicle {

    @Override
    public double calculateCharge(int hours) {

        if (hours == 1) {
            return 30;
        }

        return 30 + (20 * (hours - 1));
    }
}

class Truck extends Vehicle {

    @Override
    public double calculateCharge(int hours) {

        double charge = 50 * hours;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }
}

public class ParkingCharge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {

                case "BIKE":
                    vehicle = new Bike();
                    break;

                case "CAR":
                    vehicle = new Car();
                    break;

                default:
                    vehicle = new Truck();
                    break;
            }

            double charge = vehicle.calculateCharge(hours);

            total += charge;

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    charge
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}