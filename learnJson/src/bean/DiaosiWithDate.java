package bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ZH on 2016/11/3.
 */
public class DiaosiWithDate {
    private String name;
    private int age;
    private String gender;
    private boolean has_house;
    private List<String> iphone;
    private Object isBoy;
    //加上transient不会将此属性转换到json对象中
    private transient String dar;
    private Date birthday;

    public DiaosiWithDate() {
    }

    public DiaosiWithDate(String name, int age, String gender, boolean has_house, List<String> iphone, Object isBoy, String dar, Date birthday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.has_house = has_house;
        this.iphone = iphone;
        this.isBoy = isBoy;
        this.dar = dar;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHas_house() {
        return has_house;
    }

    public void setHas_house(boolean has_house) {
        this.has_house = has_house;
    }

    public List<String> getIphone() {
        return iphone;
    }

    public void setIphone(List<String> iphone) {
        this.iphone = iphone;
    }

    public Object getIsBoy() {
        return isBoy;
    }

    public void setIsBoy(Object isBoy) {
        this.isBoy = isBoy;
    }

    public String getDar() {
        return dar;
    }

    public void setDar(String dar) {
        this.dar = dar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "DiaosiWithDate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", has_house=" + has_house +
                ", iphone=" + iphone +
                ", isBoy=" + isBoy +
                ", dar='" + dar + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
