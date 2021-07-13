package com.example.passwordManagerMain.util;


public class CreateDetails {

	private Long Id;
	private String webSiteName;
	private String password;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public CreateDetails() {
		super();
		System.out.println("in CreateDetails");
	}
	public CreateDetails(Long id, String webSiteName, String password) {
		super();
		Id = id;
		this.webSiteName = webSiteName;
		this.password = password;
	}
	public CreateDetails(String webSiteName, String password) {
		super();
		this.webSiteName = webSiteName;
		this.password = password;
	}
	public String getWebSiteName() {
		return webSiteName;
	}
	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CreateDetails [webSiteName=" + webSiteName + ", password=" + password + "]";
	}
	
	
	
}
