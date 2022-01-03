package Controller.ExamController;

import Controller.ExamController.Exam;
import Controller.UserController.*;

public class User_Exam {
    public User_Exam(int id, int user_id, int exam_id){
        this.id = id;
        this.user_id = user_id;
        this.exam_id = exam_id;
    }

    public int id;
    public int user_id;
    public int exam_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }
}
