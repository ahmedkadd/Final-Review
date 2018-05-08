import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    protected static ArrayList<QA> QAList = new ArrayList<QA>();
    protected static Quiz quiz = new Quiz();

    public void add (QA newQuestion){
         QAList.add(newQuestion);
    }

    public boolean run (int i){
        boolean tf = false;

        QAList.get(i).displayQuestion();
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        if (QAList.get(i).checkAnswer(answer)) {
            tf = true;
            System.out.println("correct");     
        } else {
            tf = false;
            System.out.println("incorrect");
            QAList.get(i).displayAnswer();
        }   
        return tf;
    }

    public void createQuiz(){
        //type QA
        QA qa = new QA("How many states are there?", "50");
        quiz.add(qa);
        //type ChoiceQA
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("a. Sacramento");
        choices.add("b. San Francisco");
        QA cqa = new ChoiceQA("What is the capital of California?", "a", choices);
        quiz.add(cqa);
         //type NumberRangeQA
        QA nrQA = new NumberRangeQA("How old is Beyonce?", 36, 50);
        quiz.add(nrQA);
    }

    public static void main(String args[]) {
        //create questions and add them to the list
        quiz.createQuiz();
        //administer the quiz
        for (int i=0; i<QAList.size(); i++){
            quiz.run(i);  
        }

    }

}
