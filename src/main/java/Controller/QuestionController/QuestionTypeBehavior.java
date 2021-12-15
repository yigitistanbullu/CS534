package Controller.QuestionController;

import Model.QuestionModel;

public interface QuestionTypeBehavior {
    String setQuestionType();
}

class TextQuestionBehavior implements QuestionTypeBehavior {

    public String setQuestionType(){
    String type = "text";
    return type;

    }
}

class TrueFalseQuestionBehavior implements QuestionTypeBehavior {

    public String setQuestionType(){
        String type = "true_false";
        return type;
    }
}

class MultipleChoiceQuestionBehavior implements QuestionTypeBehavior {

    public String setQuestionType(){
        String type = "multiple_choice";
        return type;
    }
}


