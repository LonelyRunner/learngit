package javaTest;

/**
 * Created by ZH on 2016/7/25.
 */
public class User {
    private int id;
    private String userName;
    private String userAge;
    private String userAddress;

    public User() {

    }

    public User(int id, String userName, String userAge, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
        this.userAddress = userAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}