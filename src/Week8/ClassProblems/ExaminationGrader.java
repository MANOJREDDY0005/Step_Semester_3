import java.util.Scanner;

class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText,
                    String correctAnswer,
                    String studentAnswer,
                    double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        return 0;
    }
}

class MCQ extends Question {

    public MCQ(String questionText,
               String correctAnswer,
               String studentAnswer,
               double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TF extends Question {

    public TF(String questionText,
              String correctAnswer,
              String studentAnswer,
              double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class Essay extends Question {

    public Essay(String questionText,
                 String correctAnswer,
                 String studentAnswer,
                 double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {

        String[] keywords = correctAnswer.split(",");

        int matched = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] lastPart = parts[6].trim().split("\\s+");

            double points =
                    Double.parseDouble(lastPart[0]);

            Question question;

            if (type.equals("MCQ")) {

                question = new MCQ(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else if (type.equals("TF")) {

                question = new TF(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else {

                question = new Essay(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );
            }

            double score = question.calculateScore();

            totalScore += score;

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    score
            );
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}