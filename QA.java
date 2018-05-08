// QA is the super class for all Question and Answer objects. It contains the data members
// question and answer, a displayQuestion method which just displays the question, and a checkAnswer method.
public class QA {

    protected String question;
    protected String answer;

    public QA(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    public void displayQuestion() {
        System.out.println(question);
    }

    public boolean checkAnswer (String userAnswer) {
        return this.answer.equals(userAnswer);
    }

    public void displayAnswer() {
        System.out.println("The correct answer is: "+ answer);

    }


}
