import java.util.Scanner;

class Employee {

    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 0;
    }
}

class FullTime extends Employee {

    public FullTime(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {

    public PartTime(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {

    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            String name = sc.next();

            double salary = sc.nextDouble();

            Employee employee;

            switch (type) {

                case "FULLTIME":
                    employee = new FullTime(name, salary);
                    break;

                case "PARTTIME":
                    employee = new PartTime(name, salary);
                    break;

                default:
                    employee = new Intern(name, salary);
                    break;
            }

            double bonus = employee.calculateBonus();

            totalBonus += bonus;

            System.out.printf(
                    "%s: %.2f%n",
                    name,
                    bonus
            );
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus
        );

        sc.close();
    }
}
