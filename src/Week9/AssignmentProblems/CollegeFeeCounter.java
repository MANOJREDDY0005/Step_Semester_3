import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();

        if (this instanceof BusUser) {
            fee += ((BusUser) this).transportFee();
        }

        return fee;
    }
}

interface BusUser {
    double BUS_FEE = 12000;

    default double transportFee() {
        return BUS_FEE;
    }
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {

    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            }
            else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            }
            else if (type.equals("SCHOLAR")) {
                students[i] = new Scholar(name);
            }
        }

        double total = 0;

        for (Student student : students) {

            double fee = student.totalFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}