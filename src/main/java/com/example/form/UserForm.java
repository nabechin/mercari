package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class UserForm {

	private String id;
	@NotBlank(message="入力必須です")
	private String name;
	@NotBlank(message="入力必須です")
    @Email(message="メールアドレスの形式が不正です")
	private String email;
    @Size(min=1,max=10,message="パスワードは1文字以上,1文字以内でお願いします")
	private String password;
	private String authority;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", authority="
				+ authority + "]";
	}

}
