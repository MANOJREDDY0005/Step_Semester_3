import java.time.LocalDate;
import java.util.Scanner;

class SubscriptionPlan {

    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate;
    }
}

class BasicPlan extends SubscriptionPlan {

    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {

    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {

    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            String name = sc.next();

            LocalDate startDate =
                    LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            switch (type) {

                case "BASIC":
                    plan = new BasicPlan();
                    break;

                case "STANDARD":
                    plan = new StandardPlan();
                    break;

                default:
                    plan = new PremiumPlan();
                    break;
            }

            LocalDate renewalDate =
                    plan.calculateRenewalDate(startDate);

            System.out.println(
                    name + ": " + renewalDate
            );
        }

        sc.close();
    }
}
