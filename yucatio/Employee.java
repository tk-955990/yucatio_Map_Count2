package yucatio;

import java.nio.charset.Charset;

public class Employee {

	Employee() {}

	public Employee(String name,String section,String gender) {
		this.name = name;
		this.section = section;
		this.gender = gender; 
	}

	private String name;
	private String section;
	private String gender;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
/*	public String toString1() {
		return String.format("名前:%-15s 部署:%-15s 性別:%s", this.name,this.section,this.gender );
	}
*/
	public String toString() {
		return "名前:" + format(this.name, 15) + "部署:" + format(this.section, 24) + "性別:" + format(this.gender,5);
	}
	
	private String format(String target, int length) {
		int byteDiff = (getByteLength(target, Charset.forName("UTF-8")) - target.length()) / 2;
		return String.format("%-" + (length - byteDiff) + "s", target);
	}
	
	private int getByteLength(String string, Charset charset) {
		return string.getBytes(charset).length;
	}
	
}