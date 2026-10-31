import java.util.Arrays;

public class ThePrizeTable {

    static int prizeTable(int[] marks) {

        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < marks.length; j++) {

                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {

                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] a = {45, 90, 60, 75};

        int swaps1 = prizeTable(a);

        System.out.println(Arrays.toString(a));
        System.out.println("Swaps = " + swaps1);

        int[] b = {80, 70, 60};

        int swaps2 = prizeTable(b);

        System.out.println(Arrays.toString(b));
        System.out.println("Swaps = " + swaps2);
    }
}