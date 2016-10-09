package java.briup.DesignMode.MVCmode;

/**
 * Created by ZH on 2016/3/9.
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model,StudentView view){
        this.model = model;
        this.view = view;
    }

    public void setRollNo(String studentRollNo){
        model.setRollNo(studentRollNo);
    }

    public void setStudentName(String studentName){
        model.setName(studentName);
    }

    public String getRollNo(){
        return model.getRollNo();
    }

    public String getStudentName(){
        return model.getName();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(),model.getRollNo());
    }
}
