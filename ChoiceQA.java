import java.util.ArrayList;

// ChoiceQA is a subclass of QA. It inherits QA's data members question and answer, and extends
// it by adding another data member for the list of choices, and by overriding the displayQuestion method
// such that it displays the question and the choices.
public class ChoiceQA extends QA {

    ArrayList<String> choices = new ArrayList<String>();

    public ChoiceQA(String question, String answer, ArrayList<String> choices) {

        super(question,answer);
        this.choices=choices;
    }

    // override QA's display question so that we include the choices
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println(this.choices);
    }
}
