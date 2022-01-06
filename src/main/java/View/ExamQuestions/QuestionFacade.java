package View.ExamQuestions;

public class QuestionFacade {

    public int questionId;
    public int userId;
    QuestionMaker maker = new QuestionMaker(questionId, userId);

    public QuestionFacade(int questionId, int userId) {
        this.questionId = questionId;
        this.userId = userId;

        maker.createGapFilling();
        maker.createMultipleQuestion();
        maker.createMultipleSelection();
        maker.createText();
        maker.createTrueFalse();
    }
}
