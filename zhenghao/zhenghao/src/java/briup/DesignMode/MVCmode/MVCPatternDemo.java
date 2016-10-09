package java.briup.DesignMode.MVCmode;

/**
 * Created by ZH on 2016/3/9.
 */
public class MVCPatternDemo {
    public static void main(String args[]){
        Student model = BuildingStudentModel();
        StudentView view = new StudentView();

        StudentController sc = new StudentController(model,view);
        sc.updateView();

        sc.setStudentName("John");
        sc.updateView();
    }

    public static Student BuildingStudentModel(){
        Student s = new Student();
        s.setRollNo("0101");
        s.setName("约翰");
        return s;
    }
}
