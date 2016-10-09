package java.briup.basic.aboutCollection.aboutMap;

/**
 * Created by ZH on 2015/11/16.
 */
public class Student {
    private String name;
    private String gender;
    private int age;
    private String introduce;

    public Student() {
    }

    public Student(String name, String gender, int age, String introduce) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
