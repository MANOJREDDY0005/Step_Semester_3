import java.util.Scanner;

class Room {

    public double calculateBill(int units) {
        return 0;
    }
}

class SingleRoom extends Room {

    @Override
    public double calculateBill(int units) {
        return 8 * units;
    }
}

class SharedRoom extends Room {

    private int occupants;

    public SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    @Override
    public double calculateBill(int units) {
        return (6 * units) / occupants;
    }
}

class ACRoom extends Room {

    @Override
    public double calculateBill(int units) {
        return (10 * units) + 200;
    }
}

public class ElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            int units = sc.nextInt();

            Room room;

            switch (type) {

                case "SINGLE":
                    room = new SingleRoom();
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;

                default:
                    room = new ACRoom();
                    break;
            }

            double bill = room.calculateBill(units);

            total += bill;

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    bill
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}