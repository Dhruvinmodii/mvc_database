package mvccrud.model;

public class User {

	//same variable name which we give in contact.jsp page
	private String email;
	private String username;
	private String userpass;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", userpass=" + userpass + "]";
	}
	
	
	
	
	
}
