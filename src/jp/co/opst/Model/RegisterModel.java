package jp.co.opst.Model;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.opst.Model.RegisterModel.Group1;

@GroupSequence({ Group1.class, RegisterModel.class })
public class RegisterModel {
	public interface Group1 {
	}
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 20, message = "20文字以内で入力してください")
	private String name;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 3, message = "3桁以内で入力してください")
	@Pattern(regexp = "[0-9]*", message = "半角数字で入力してください")
	private String age;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String sex;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 8, message = "8文字以内で入力してください")
	@Pattern(regexp = "^[0-9]{7}$", message = "正しく入力してください")
	private String postCode;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 50, message = "50文字以内で入力してください")
	private String address;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	@Size(max = 20, message = "20文字以内で入力してください")
	@Pattern(regexp = "[0-9]{2,4}[0-9]{2,4}[0-9]{3,4}", message = "正しいフォーマットで入力してください")
	private String phoneNum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
