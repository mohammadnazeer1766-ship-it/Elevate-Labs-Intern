import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Which language is used for Android Development?", 
                new String[]{"Python", "Java", "C++", "Ruby"}, 2));

        quiz.add(new Question("Which company developed Java?", 
                new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"}, 3));

        quiz.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"implement", "extends", "inherits", "super"}, 2));

        int score = 0;

        System.out.println("===== Welcome to Java Quiz =====\n");

        for (Question q : quiz) {
            q.display();
            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✘ Wrong!\n");
            }
        }

        System.out.println("===== QUIZ FINISHED =====");
        System.out.println("Your Score: " + score + " / " + quiz.size());
        
        sc.close();
    }
}
