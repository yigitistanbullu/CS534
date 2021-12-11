package Controller.QuestionController;

public abstract class QuestionFactory {

    public void addQuestion(){

        Question question = createQuestion();
        question.setAnswerBehavior();
        question.setGradingBehavior();
        question.display();

    }

    public void deleteQuestion(){

    }

    protected abstract Question createQuestion();


}
