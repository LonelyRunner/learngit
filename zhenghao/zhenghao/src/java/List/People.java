package java.List;

/**
 * Created by ZH on 2016/1/27.
 */
public class People {
    private String ctrValue;
    private String name;
    private String gender;
    private Integer age;

    public People(){

    }
    public People(String ctrValue, String name, String gender, Integer age) {
        this.ctrValue = ctrValue;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getCtrValue() {
        return ctrValue;
    }

    public void setCtrValue(String ctrValue) {
        this.ctrValue = ctrValue;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "ctrValue='" + ctrValue + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
