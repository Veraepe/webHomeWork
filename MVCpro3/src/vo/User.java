package vo;

public class User {

	private String userName;
	private String password;
	private String role;
	private String province;
	private String city;
	private String telephone;
	private String email;
	
	
	public User() {
		super();
	}

	public User(String userName, String password, String role,String province,String city,String telephone,String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.province=province;
		this.city=city;
		this.telephone=telephone;
		this.email=email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + ", province=" + province
				+ ", city=" + city + ", telephone=" + telephone + ", email=" + email + "]";
	}

	
	
}
