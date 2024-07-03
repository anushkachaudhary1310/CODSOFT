import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class t4final {

    private static volatile boolean timeUp = false; // Use volatile to ensure visibility across threads

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // Input of the quiz questions, answers, and multiple choices by the teaching staff
        System.out.println("Enter the number of questions in the quiz: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] Questions = new String[n];
        String[] MultipleChoices = new String[4 * n];
        String[] AnswerKey = new String[n];
        final int[] c = {0}; // Use an array to allow modification within lambda
        System.out.println("Enter the Questions along with the multiple choice options and correct answer.");

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th Question: ");
            Questions[i] = sc.nextLine();

            System.out.println("Enter the multiple choices for " + (i + 1) + "th Question");
            for (int j = 0; j < 4; j++) {
                MultipleChoices[c[0]] = sc.nextLine();
                ++c[0];
            }
            System.out.println("Enter the correct answer for the question: ");
            AnswerKey[i] = sc.nextLine();
        }

        // Display the questions and multiple choices and choose one of them using 1 2 3 4 options 
        System.out.println("Press 'S' to start the quiz");
        char start = sc.nextLine().charAt(0);
        c[0] = 0; // Reset counter for quiz
        int[] choice = new int[n];
        int score = 0;

        if (Character.toUpperCase(start) == 'S') {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                }
            }, 60000);

            Thread quizThread = new Thread(() -> {
                for (int k = 0; k < n && !timeUp; k++) {
                    System.out.println("Ques " + (k + 1) + ": " + Questions[k]);
                    System.out.print("1: " + MultipleChoices[c[0]] + " \t 3: " + MultipleChoices[c[0] + 2]);
                    System.out.println();
                    System.out.print("2: " + MultipleChoices[c[0] + 1] + " \t 4: " + MultipleChoices[c[0] + 3]);
                    System.out.println();
                    c[0] = c[0] + 4;
                    System.out.println("Your choice: ");
                    if (sc.hasNextInt()) {
                        choice[k] = sc.nextInt();
                        sc.nextLine(); // consume the newline
                    } else {
                        sc.nextLine(); // consume the invalid input
                        System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    }
                }
            });

            quizThread.start();

            try {
                quizThread.join(60000); // Wait for 60 seconds or until the quiz thread finishes
            } catch (InterruptedException e) {
                System.out.println("Quiz interrupted");
            }

            if (timeUp) {
                System.out.println("Time is up!");
            }

            timer.cancel(); // Cancel the timer after quiz completion or timeout

            c[0] = 0; // Reset counter for results
            String[] results = new String[n];
            for (int r = 0; r < n; r++) {
                if (r >= choice.length || choice[r] == 0) {
                    results[r] = "Unanswered";
                } else {
                    int selectedIndex = (choice[r] - 1) % 4;
                    if (MultipleChoices[c[0] + selectedIndex].equals(AnswerKey[r])) {
                        score++;
                        results[r] = "Correct";
                    } else {
                        results[r] = "Incorrect";
                    }
                }
                c[0] += 4;
            }

            System.out.println("Your total score is: " + score);
            System.out.println("Summary of your answers:");
            for (int r = 0; r < n; r++) {
                System.out.println("Q" + (r + 1) + ": " + Questions[r]);
                if (r < choice.length && choice[r] != 0) {
                    System.out.println("Your choice: " + choice[r] + " - " + MultipleChoices[(r * 4) + (choice[r] - 1) % 4]);
                } else {
                    System.out.println("Your choice: Unanswered");
                }
                System.out.println("Correct answer: " + AnswerKey[r]);
                System.out.println("Result: " + results[r]);
                System.out.println();
            }
        } else {
            System.out.println("Invalid choice. Score is 0");
        }
    }
}
