package il.ac.hit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean admin;
	private String businessName;
	private static Logger log = LogManager.getRootLogger();

	/** 
	 * Class constructor.
	 */
	public User(){}
	
	/**
	 * Class constructor with parameters.
	 * @param username A string that represents the user's username
	 * @param password A string that represents the user's encrypted password
	 * @param admin A boolean value that specifies whether the user is an admin or not
	 * @param businessName A string that represents the business name that is associated with this user
	 */
	public User(String username, String password, boolean admin, String businessName) {
		super();
		setUsername(username);
		setPassword(password);
		setAdmin(admin);
		setBusinessName(businessName);
		log.info("CouponTable | User object created!");
	}

	/**
	 * 
	 * @return A string that represents the username of the user object
	 */
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return A string that represents the encrypted password of the user object
	 */
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return A boolean value that specifies whether the user is an admin or not
	 */
	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * 
	 * @return A string that represents the business name associated with this user
	 */
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", admin=" + admin + "]";
	}
	
	
}
