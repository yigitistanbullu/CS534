package View.ExamQuestions;

import Model.ExamModel;
import Model.QuestionModel;

public class QuestionMaker {
    private Question gapFilling;
    private Question multipleChoice;
    private Question multipleSelection;
    private Question text;
    private Question trueFalse;
    private TextQuestion.Builder builderText;
    private TrueFalseQuestion.Builder builderTrueFalse;
    private MultipleSelection.Builder builderSelection;
    private MultipleQuestion.Builder builderMultiple;
    private GapFillingQuestion.Builder builderGap;
    public int questionID;
    public int userID;
    ExamModel model = new ExamModel();

    public QuestionMaker(int questionID, int userID) {
        gapFilling = new GapFillingQuestion(builderGap);
        multipleChoice = new MultipleQuestion(builderMultiple);
        multipleSelection = new MultipleSelection(builderSelection);
        text = new TextQuestion(builderText);
        trueFalse = new TrueFalseQuestion(builderTrueFalse);
        this.questionID = questionID;
        this.userID = userID;

    }

    public void createGapFilling(){
        gapFilling.disableGradeFieldForStudent();
        gapFilling.removeGradeForExamination();
        gapFilling.setAnswerForReview(questionID, userID);
        gapFilling.setComponents(questionID);
    }

    public void createMultipleQuestion(){
        gapFilling.disableGradeFieldForStudent();
        gapFilling.removeGradeForExamination();
        gapFilling.setAnswerForReview(questionID, userID);
        gapFilling.setComponents(questionID);
    }

    public void createMultipleSelection(){
        gapFilling.disableGradeFieldForStudent();
        gapFilling.removeGradeForExamination();
        gapFilling.setAnswerForReview(questionID, userID);
        gapFilling.setComponents(questionID);
    }

    public void createText(){
        gapFilling.disableGradeFieldForStudent();
        gapFilling.removeGradeForExamination();
        gapFilling.setAnswerForReview(questionID, userID);
        gapFilling.setComponents(questionID);
    }

    public void createTrueFalse(){
        gapFilling.disableGradeFieldForStudent();
        gapFilling.removeGradeForExamination();
        gapFilling.setAnswerForReview(questionID, userID);
        gapFilling.setComponents(questionID);
    }
}


