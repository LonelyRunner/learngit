package bean;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by ZH on 2016/11/2.
 */
public class Diaosi {

//    @SerializedName("NAME")
    private String name;
    private int age;
    private String gender;
    private boolean has_house;
    private String[] iphone;
    private Object isBoy;
    //加上transient不会将此属性转换到json对象中
    private transient String dar;
    private String birthday;

    public Diaosi() {
    }

    public Diaosi(String name, int age, String gender, boolean has_house, String[] iphone, Object isBoy, String dar, String birthday) {
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

    public String[] getIphone() {
        return iphone;
    }

    public void setIphone(String[] iphone) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Diaosi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", has_house=" + has_house +
                ", iphone=" + Arrays.toString(iphone) +
                ", isBoy=" + isBoy +
                ", dar='" + dar + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
