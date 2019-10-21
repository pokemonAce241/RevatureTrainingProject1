package dev.jason.entities;

public class User {
	
	private int id;
	
	private String username;
	private String password;
	
	private String employee_position;
	
	
	public User(){
		super();
	}

	public User(int id, String username, String password, String employee_position) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.employee_position = employee_position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployee_position() {
		return employee_position;
	}

	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee_position == null) ? 0 : employee_position.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (employee_position == null) {
			if (other.employee_position != null)
				return false;
		} else if (!employee_position.equals(other.employee_position))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", employee_position="
				+ employee_position + "]";
	}
	
	

}
