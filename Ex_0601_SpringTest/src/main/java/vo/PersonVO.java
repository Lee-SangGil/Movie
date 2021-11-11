package vo;

public class PersonVO {

	private String name;
	private int age;
	private String tel;
	
	public PersonVO(String name, int age, String tel) {
		System.out.println("오버로딩 생성자 호출");
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	
	public PersonVO() {
		System.out.println("-- personvo의 기본 생성자가 호출됌--");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName()이 호출됌");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
