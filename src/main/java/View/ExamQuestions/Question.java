package View.ExamQuestions;

public interface Question {
    void setComponents(int questionID);
    void setAnswerForReview(int questionId, int userId);
    void removeGradeForExamination();
    void disableGradeFieldForStudent();
}
