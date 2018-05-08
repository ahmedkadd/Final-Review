import java.util.ArrayList;

public class QA {

    private String question;
    private String answer;
    private ArrayList<String> choices = new ArrayList<String>();

    public QA(String q, String a, ArrayList<String> choices) {
        this.question=q;
        this.answer=a;
        this.choices=choices;
    }

    public String getQuestion() { return this.question; }

    public String getAnswer() { return this.answer; }

    public boolean checkAnswer (String userAnswer) {
        return this.answer.equals(userAnswer);
    }
}
