package bean;

public class Users {
	private String userId;
	private String name;
	private int age;
	private String sex;
	private String area;
	private long tel;
	
	public Users(){
		
	}

	public Users(String userId, String name, int age, String sex, String area, long tel) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.area = area;
		this.tel = tel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", age=" + age + ", sex=" + sex + ", area=" + area
				+ ", tel=" + tel + "]";
	}
}
